class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        int temp = start + (end - start + 1) / 2;
        TreeNode root = new TreeNode(nums[temp]);
        if (start <= temp - 1) {
            root.left = helper(nums, start, temp - 1);
        }
        if (end >= temp + 1) {
            root.right = helper(nums, temp + 1, end);
        }

        return root;
    }
}
