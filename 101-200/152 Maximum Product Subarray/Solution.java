class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int lastMax = max, lastMin = min;
            max = Math.max(nums[i], Math.max(lastMax * nums[i], lastMin * nums[i]));
            min = Math.min(nums[i], Math.min(lastMax * nums[i], lastMin * nums[i]));
            result = Math.max(max, result);
        }

        return result;
    }
}
