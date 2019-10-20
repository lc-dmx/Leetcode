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
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root != null) {
            TreeNode temp = helper(root.left);
            root.left = helper(root.right);
            root.right = temp;
        }
        return root;
    }
}
