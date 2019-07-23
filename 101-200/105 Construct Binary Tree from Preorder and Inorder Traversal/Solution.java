PreOrder: GDAFEMHZ 
InOrder: ADEFGHMZ
1 ）preorder第一个元素为root，即G 
2 ）inorder中G左边的ADEF为左子树，右边的HMZ为右子树《--知道左右子树的长度也就可以在preorder中确定左右子树的范围了，因为preorder的顺序一定是 {root  [左子树] [右子树]} 
3 ）inorder中的ADEF对应 preorder中的DAFE 
4 ）inorder中的HMZ对应preorder中的MHZ 
5 ）对3） 4） 得到的子树重复应用1） 2）的步骤最终就可以得到整棵树。

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return recursive(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recursive(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = recursive(preorder, inorder, preStart + 1, preStart + inIndex - inStart, inStart, inIndex - 1);
        root.right = recursive(preorder, inorder, preStart + inIndex - inStart + 1, preEnd, inIndex + 1, inEnd);
        return root;
    }
}
