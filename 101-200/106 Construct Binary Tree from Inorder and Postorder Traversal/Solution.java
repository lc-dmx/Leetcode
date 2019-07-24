class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = helper(inorder, postorder, inStart, inIndex - 1, postStart, postStart + inIndex - inStart - 1);
        root.right = helper(inorder, postorder, inIndex + 1, inEnd, postStart + inIndex - inStart, postEnd - 1);
        return root;
    }

}
