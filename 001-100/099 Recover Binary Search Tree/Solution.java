# Solution 1
class Solution {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}

# Solution 2
class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = null, second = null, prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (prev != null && prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
