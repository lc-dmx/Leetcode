/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

# Solution 1 递归法

时间 O(N) 空间 O(N) 递归栈空间

如果当前节点有左孩子，那么左孩子的next就指向右孩子。
如果当前节点有右孩子，那么判断，如果当前节点的next是null，说明当前节点已经到了最右边，那么右孩子也是最右边的，所以右孩子指向null。
如果当前节点的next不是null，那么当前节点的右孩子的next就需要指向当前节点next的左孩子。

class Solution {
    public Node connect(Node root) {
        if (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null) {
                if (root.next == null) {
                    root.right.next = null;
                } else {
                    root.right.next = root.next.left;
                }
            }

            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}

# Solution 2 双指针法

时间 O(N) 空间 O(1)

实际上，我们可以用一个指针记录当前层内遍历到的节点，另一个指针记录下一层第一个节点，来省去空间开销。
这样，我们可以基于上一层的next指针进行横向遍历，同时遍历到该层尽头时又能使用记录下的下一层第一个节点的指针来直接跳转到下一层。

class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        //记录该层当前节点的指针，也叫做父节点，我们通过遍历父节点，来连接它们的子节点
        TreeLinkNode p = root;
        //记录下层第一个节点的指针
        TreeLinkNode first = null;
        while(p != null){
            //当first为空时，说明刚跳转到新的一层，需要设置下一层的第一个节点了
            if(first == null){
                first = p.left;
            }
            //如果有左子节点，则其next是右子节点，如果没有，则遍历结束
            //因为我们实际上是将下一层的节点用next指针连接，所以当遍历到叶子结点时已经没有下一层
            if(p.left != null){
                p.left.next = p.right; 
            } else {
                break;
            }
            //如果父节点有next，则next的左子节点是父节点的右子节点的next，如果没有，说明这层遍历完了，转入下一层
            if(p.next != null){
                p.right.next = p.next.left;
                p = p.next;
            } else {
                p = first;
                first = null;
            }
        }
    }
}

# Solution 3 层次递进法

时间 O(N) 空间 O(1)

因为我们确定的知道每个非叶子节点都有左右节点，所以我们可以一层一层链接。只要根据当前层的next指针形成的链表，将下一层的左右左右连起来就行了。

class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null){
            // 记录当层第一个节点
            TreeLinkNode tmpHead = head;
            // 开始链接下一层
            while(head != null){
                //链接左节点
                if(head.left != null) head.left.next = head.right;
                //链接右节点
                if(head.right != null) head.right.next = head.next != null ? head.next.left : null;
                head = head.next;
            }
            // 跳到下一层第一个节点
            head = tmpHead.left;
        }
    }
}
