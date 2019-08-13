算法描述：

当fast若与slow相遇时，slow肯定没有走遍历完链表，而fast已经在环内循环了n圈(1<=n)。假设slow走了s步，则fast走了2s步
（fast步数还等于s加上在环上多转的n圈），设环长为r，则：

2s = s + nr
s= nr

设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。
a + x = nr
a + x = (n – 1)r +r = (n-1)r + L - a
a = (n-1)r + (L – a – x)

(L – a – x)为相遇点到环入口点的距离，由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点.
于是我们从链表头、与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
//     public ListNode detectCycle(ListNode head) {
//         ListNode fast = head;
//         ListNode slow = head;

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;
//             if (fast == slow) {
//                 break;
//             }
//         }

//         if (fast == null || fast.next == null) {
//             return null;
//         }

//         slow = head;
//         while (fast != slow) {
//             fast = fast.next;
//             slow = slow.next;
//         }

//         return slow;
//     }
}
