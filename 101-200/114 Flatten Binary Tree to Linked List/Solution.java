class Solution {
    public void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) flatten(root.left);
            if (root.right != null) flatten(root.right);
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = tmp;
        }
    }
}
