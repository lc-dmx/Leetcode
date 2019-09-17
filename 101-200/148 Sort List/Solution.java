/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        
        return helper(sortList(head), sortList(slow));
    }
    
    private ListNode helper(ListNode head, ListNode slow) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (head != null && slow != null) {
            if (head.val <= slow.val) {
                temp.next = head;
                head = head.next;
            } else {
                temp.next = slow;
                slow = slow.next;
            }
            temp = temp.next;
        }

        if (head != null) {
            temp.next = head;
        }

        if (slow != null) {
            temp.next = slow;
        }

        return dummy.next;
    }
}
