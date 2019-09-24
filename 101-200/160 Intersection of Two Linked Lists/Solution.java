/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode temp = headA;
        while (temp != null) {
            len1++;
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            len2++;
            temp = temp.next;
        }

        int diff = len1 - len2;
        if (diff > 0) {
            while (diff != 0) {
                diff--;
                headA = headA.next;
            }
        } else if (diff < 0) {
            while (diff != 0) {
                diff++;
                headB = headB.next;
            }
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
