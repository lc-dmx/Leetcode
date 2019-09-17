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

# 快排
public ListNode sortList(ListNode head) {
    //采用快速排序
   quickSort(head, null);
   return head;
}
public static void quickSort(ListNode head, ListNode end) {
    if (head != end) {
        ListNode node = partion(head, end);
        quickSort(head, node);
        quickSort(node.next, end);
    }
}

public static ListNode partion(ListNode head, ListNode end) {
    ListNode p1 = head, p2 = head.next;

    //走到末尾才停
    while (p2 != end) {

        //大于key值时，p1向前走一步，交换p1与p2的值
        if (p2.val < head.val) {
            p1 = p1.next;

            int temp = p1.val;
            p1.val = p2.val;
            p2.val = temp;
        }
        p2 = p2.next;
    }

    //当有序时，不交换p1和key值
    if (p1 != head) {
        int temp = p1.val;
        p1.val = head.val;
        head.val = temp;
    }
    return p1;
}
