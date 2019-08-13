/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p, q, r;
        p = dummy.next.next;
        dummy.next.next = null;

        while (p != null) {
            q = p.next;
            r = dummy;
            
            while (r.next != null && r.next.val < p.val) {
                r = r.next;
            }
            p.next = r.next;
            r.next = p;
            
            //上面一段等价于下面一段
//            while (r.next != null) {
//                if (p.val < r.next.val) {
//                    p.next = r.next;
//                    r.next = p;
//                    break;
//                } else {
//                    r = r.next;
//                }
//            }
//            if (r.next == null) {
//                p.next = null;
//                r.next = p;
//            }

            p = q;
        }
        return dummy.next;
    }
}
