/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;

        while (first != null && first.next != null) {
            if (first.val == first.next.val) {
                while (first.next != null && first.val == first.next.val) {
                    first = first.next;
                }
                second.next = first;
            } else {
                second = first;
                first = first.next;
            }
        }
        return dummy.next;
    }
}
