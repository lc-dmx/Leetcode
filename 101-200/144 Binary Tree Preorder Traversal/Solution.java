class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode r = stack.pop();
            result.add(r.val);

            if (r.right != null) {
                stack.add(r.right);
            }
            if (r.left != null) {
                stack.add(r.left);
            }
        }

        return result;
    }
}
