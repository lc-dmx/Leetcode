class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                m = nums[i];
                count = 1;
            } else {
                if (m == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }

        }
        return m;
    }
}
