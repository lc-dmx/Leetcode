class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root, visited = root;

        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }

        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp.right != null && temp.right != visited) {
                stack.push(temp);
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            } else {
                result.add(temp.val);
                visited = temp;
            }
        }
        return result;
    }
}
