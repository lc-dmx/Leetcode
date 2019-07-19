# Solution 1
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }

        if (root.val > min && root.val < max) {
            return isValidBSTHelper(root.left, root.val, min) && isValidBSTHelper(root.right, max, root.val);
        }
        
        return false;
    }
}

# Solution 2
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double number = -Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (root.val <= number) return false;

            number = root.val;
            root = root.right;
        }

        return true;
    }
}
