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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    private void inorder(List<Integer> result, TreeNode root){
        if (root != null) {
            inorder(result, root.left);
            result.add(root.val);
            inorder(result, root.right);
        }
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;

        while (tmp != null || !stack.isEmpty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            result.add(tmp.val);
            tmp = tmp.right;
        }

        return result;
    }
}
