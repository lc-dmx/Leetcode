#Iteration
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode tmp = null;
        TreeNode next = null;
        while(cur != null){
            next = cur.left;
            //need tmp to keep the previous right child
            cur.left = tmp;
            tmp = cur.right;
             
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

#Recursive
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        //root.left is newRoot everytime
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
