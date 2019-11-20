class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }

        temp &= -temp;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & temp) != 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }

        return result;
    }
}
