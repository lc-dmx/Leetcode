# Solution 1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head, last = slow;
        while (fast != null && fast.next != null) {
            last = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        last.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        if (head != slow) root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);
        return root;
    }
}

# Solution 2
Class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return recursion(head, null);

    }

    private TreeNode recursion(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode fast = head, slow = head;
        while (fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = recursion(head, slow);
        root.right = recursion(slow.next, tail);

        return root;
    }
}

# Solution 3
class Solution {
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        cur = head;
        return sortedListToBST(0, count - 1);
    }
    
    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo + 1) / 2;
        
        TreeNode left = sortedListToBST(lo, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = sortedListToBST(mid + 1, hi);
        
        root.left = left;
        root.right = right;
        return root;
    }
}
