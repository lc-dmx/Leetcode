/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode dummy = head;
        int length = 1;
        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }

        dummy.next = head;
        k %= length;
        length -= k;

        while (length > 0) {
            dummy = dummy.next;
            length--;
        }

        head = dummy.next;
        dummy.next = null;

        return head;
    }
}
