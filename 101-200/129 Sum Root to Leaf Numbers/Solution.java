# Solution 1 递归
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int result) {
        if (root == null) {
            return 0;
        }

        result = result * 10 + root.val;
        if (root.left == null && root.right == null) return result;

        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        return left + right;
    }
}

# Solution 2 迭代
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int result = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left == null && temp.right == null) {
                result += temp.val;
                continue;
            }

            if (temp.right != null) {
                temp.right.val += temp.val * 10;
                stack.push(temp.right);
            }

            if (temp.left != null) {
                temp.left.val += temp.val * 10;
                stack.push(temp.left);
            }
        }

        return result;
    }
}
