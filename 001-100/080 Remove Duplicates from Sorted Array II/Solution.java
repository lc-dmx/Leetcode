class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        int index = 1;
        boolean fill = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (!fill) {
                    fill = true;
                    nums[index] = nums[i];
                    index++;
                }
            } else {
                fill = false;
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}
