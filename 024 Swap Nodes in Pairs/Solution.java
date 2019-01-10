/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
// ListNode tmp = head.next;
// become : 2 -> 3 -> 4
// head.next = tmp.next;
// become : 1 -> 3 -> 4
// tmp.next = head;
// become : 2 -> 1 -> 3 -> 4
//如果要对后续的元素也进行swap，只用递归替换掉tmp.next即可
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        
        return temp;
        
        
//         if(head == null || head.next == null){
//             return head;
//         }
        
//         ListNode first = head, second = head.next, dummy = second, prev = null;
//         while(first != null && second != null){
//             first.next = second.next;
//             second.next = first;
            
//             if(prev != null){
//                 prev.next = second;
//             }
            
//             if(first.next == null){
//                 break;
//             }
            
//             second = first.next.next;
//             prev = first;
//             first = first.next;
//         }
        
//         return dummy;
    }
}
