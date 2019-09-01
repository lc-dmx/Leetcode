/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = head;
        while (dummy != null) {
            Node temp = new Node(dummy.val, null, null);
            temp.next = dummy.next;
            dummy.next = temp;
            dummy = temp.next;
        }

        dummy = head;
        while (dummy != null) {
            if (dummy.random != null) dummy.next.random = dummy.random.next;
            dummy = dummy.next.next;
        }

        dummy = head;
        Node result = head.next;
        while (dummy != null) {
            Node temp = dummy.next;
            dummy.next = temp.next;
            if (temp.next != null) temp.next = temp.next.next;
            dummy = dummy.next;
        }
        return result;
    }
}
