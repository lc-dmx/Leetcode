/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        
        
        int i = 0;
        while(cur != null){
            i++;
            
            if(i % k == 0){
                pre = swap(pre, cur.next);
                cur = pre.next;
            }else{
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
    
    public ListNode swap(ListNode pre, ListNode nex){
        ListNode last = pre.next;
        ListNode cur = last.next;
        
        while(cur != nex){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        
        return last;
    }
}

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode cur = head;
//
//        for (int i = 0; i < k; i++) {
//            if (cur == null) {
//                return head;
//            }
//            cur = cur.next;
//        }
//        ListNode new_head = invert(head, cur);
//        head.next = reverseKGroup(cur, k);
//        return new_head;
//    }
//
//    public ListNode invert(ListNode head, ListNode cur) {
//        ListNode p = cur;
//        while (head != cur) {
//            ListNode q = head.next;
//            head.next = p;
//            p = head;
//            head = q;
//        }
//        return p;
//    }


//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode curr = dummy, preHead = dummy, postTail, tmp;
//        int count = 0;
//        while (curr.next != null) {
//            curr = curr.next;
//            count++;
//            if (count == k) {
//                postTail = curr.next;
//                preHead.next = null;
//                curr.next = null;
//                curr = head;
//                while (curr != null) {
//                    tmp = curr.next;
//                    curr.next = preHead.next;
//                    preHead.next = curr;
//                    curr = tmp;
//                }
//                head.next = postTail;
//                preHead = head;
//                curr = head;
//                head = postTail;
//                count = 0;
//            }
//        }
//        return dummy.next;
//    }
