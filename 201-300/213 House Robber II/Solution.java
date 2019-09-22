class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }

    private int helper(int[] nums, int start, int end) {
        int rob = 0, notRob = 0;
        for (int i = start; i < end; i++) {
            int prevRob = rob, prevNotRob = notRob;
            rob = prevNotRob + nums[i];
            notRob = Math.max(prevRob, prevNotRob);
        }

        return Math.max(rob, notRob);
    }
}
