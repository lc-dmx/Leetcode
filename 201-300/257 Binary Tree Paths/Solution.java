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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) dfs(root, result, "");
        return result;
    }

    private void dfs(TreeNode root, List<String> result, String temp) {
        if (root.left == null && root.right == null) {
            result.add(temp + root.val);
            return;
        }

        temp += root.val + "->";

        if (root.left != null) dfs(root.left, result, temp);
        if (root.right != null) dfs(root.right, result, temp);
    }
}
