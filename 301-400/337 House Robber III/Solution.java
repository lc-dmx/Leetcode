# Solution 1
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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = 0;
        if (root.left != null) {
            val += helper(root.left.left, map) + helper(root.left.right, map);
        }

        if (root.right != null) {
            val += helper(root.right.left, map) + helper(root.right.right, map);
        }

        val = Math.max(root.val + val, helper(root.left, map) + helper(root.right, map));
        map.put(root, val);
        return val;
    }
}

# Solution 2
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
    public int rob(TreeNode root) {
        int[] max = helper(root);
        return Math.max(max[0], max[1]);
    }

    private int[] helper(TreeNode root) {
        int[] max = {0, 0};
        if (root != null) {
            int[] left = helper(root.left);
            int[] right = helper(root.right);

            max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            max[1] = left[0] + right[0] + root.val;
        }
        return max;
    }
}
