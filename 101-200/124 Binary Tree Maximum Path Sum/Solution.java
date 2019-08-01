这里面有一个默认的事实，那就是不管这个路径在哪，他都肯定有一个最高的节点。我们不妨可以设这个节点为A，以A为最高节点的路径的最大长度是多少呢？

A有左右两个孩子（当然孩子可以是空），以每个孩子为起点，向下延伸，可以得到很多条单向的路径，这其中当然有一个最大路径。我们将以左孩子为起点的最大路径的值记为left_val，将以右孩子为起点的最大路径的值记为right_val，显然以A为最高点的最大路径只可能有以下四种情况：

1. 若left_val < 0, 且right_val < 0, 那最大路径为A节点本身：maxPathSum(A) = A.val

2. 若left_val > 0, 且right_val < 0, 那最大路径为A节点和以A的左孩子为起点的最大路径：maxPathSum(A) = A.val + left_val

3. 若left_val < 0, 且right_val > 0, 那最大路径为A节点和以A的右孩子为起点的最大路径：maxPathSum(A) = A.val + right_val

3. 若left_val > 0, 且right_val > 0, 那最大路径为A节点和以A的左、右孩子为起点的最大路径三者的联合：maxPathSum(A) = A.val + left_val + right_val

综上，以A为最高点的最大路径是上面四种情况的最大值。那我们遍历二叉树的所有节点，求以每个节点为最高节点的最大路径的最大值即可。

class Solution {
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root != null) {
            int left = 0, right = 0;
            if (root.left != null) {
                left = Math.max(helper(root.left), 0);
            }

            if (root.right != null) {
                right = Math.max(helper(root.right), 0);
            }

            result = Math.max(result, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
        return 0;
    }
}
