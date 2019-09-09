class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
}

class LRUCache {
    Map<Integer, DLinkedNode> cache;
    int size;
    int count;
    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        size = capacity;
        count = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    //通过 HashMap 找到 LRU 链表节点，因为根据LRU 原理，这个节点是最新访问的，所以要把节点插入到队头，然后返回缓存的值
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        //首先在 HashMap 找到 Key 对应的节点
        DLinkedNode node = cache.get(key);

        if (node == null) {
            //如果不存在，需要构造新的节点，并且尝试把节点塞到队头
            DLinkedNode tempNode = new DLinkedNode();
            tempNode.key = key;
            tempNode.value = value;

            if (count < size) {
                count++;
            } else {
                //如果LRU空间不足，则通过 tail 淘汰掉队尾的节点，同时在 HashMap 中移除 Key
                DLinkedNode tailNode = popTail();
                cache.remove(tailNode.key);
            }

            addNode(tempNode);
            cache.put(key, tempNode);
        } else {
            //如果节点存在，更新节点的值，并把这个节点移动队头
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.prev;
        DLinkedNode nex = node.next;

        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode popTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
