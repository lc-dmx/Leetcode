class Solution {
    // public int firstMissingPositive(int[] nums) {
    //     int length = nums.length;
    //     for (int i = 0; i < length; i++) {
    //         if (nums[i] > 0 && nums[i] < length) {
    //             if (nums[nums[i] - 1] != nums[i]) {
    //                 swap(nums, nums[i] - 1, i);
    //                 i--;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < length; i++) {
    //         if (nums[i] != i + 1) {
    //             return i + 1;
    //         }
    //     }
    //     return length + 1;
    // }
    
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int outOfRange = length + 1;
        for(int i = 0; i < length; i++) {
            if(nums[i] <= 0)
                nums[i] = outOfRange;
        }

        for(int i = 0; i < length; i++) {
            int temp = nums[i];
            int absTemp = Math.abs(temp);
            if(absTemp <= length)
                nums[absTemp - 1] = -Math.abs(nums[absTemp - 1]);
        }

        for(int i = 0; i < length; i++) {
            if(nums[i] > 0)
                return i + 1;
        }

        return length + 1;
    }
}
