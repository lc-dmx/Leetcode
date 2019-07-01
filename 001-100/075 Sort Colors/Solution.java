class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int start = 0;
        int end = nums.length - 1;
        int cur = 0;
        while (cur <= end) {
            if (nums[cur] == 0) {
                swap(nums, cur, start);
                cur++;
                start++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, end);
                end--;
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
