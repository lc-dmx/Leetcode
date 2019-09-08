/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        //找到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //分成两个链表，注意置空，第一个长度>=第二个链表长度
        ListNode second = slow.next;
        slow.next = null;

        //翻转第二段
        second = reverse(second);

        //合并
        merge(head, second);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private void merge(ListNode first, ListNode second) {
        while (second != null) {
            // 暂存第一个后续结点
            ListNode temp = first.next;
            first.next = second;
            first = first.next;
            second = second.next;
            first.next = temp;
            first = first.next;
        }
    }
}
