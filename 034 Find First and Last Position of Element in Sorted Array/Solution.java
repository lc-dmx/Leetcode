class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        int left = searchTarget(nums, target, true);
        //很神奇的判断
        if (left == nums.length || nums[left] != target) {
            return result;
        }
        result[0] = left;
        result[1] = searchTarget(nums, target, false) - 1;
        
        return result;
    }

    private int searchTarget(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
