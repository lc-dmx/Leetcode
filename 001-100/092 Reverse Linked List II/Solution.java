/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
1. dummy - track head position (dummy.next = head) case: if head is reversed
2. pre - point to the start of the reversed list  (0 to m-1)
3. start -  point to beginning of sub-list to be reversed(itself val unchanged) (0 to n-m swap)
4. then - point  to the node will be reversed(overall traverse the list)

![]()

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next, then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
