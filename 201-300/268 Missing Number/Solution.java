# Solution 1
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int result = nums.length * (nums.length + 1) / 2 - sum;
        return result;
    }
}

# Solution 2
class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }

        return result;
    }
}
