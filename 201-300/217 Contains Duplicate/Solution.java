# Solution 1
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}

# Solution 2
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        boolean[] flag = new boolean[max - min + 1];
        for (int num : nums) {
            if (flag[num - min]) {
                return true;
            } else{
                flag[num - min] = true;
            }
        }
        return false;
    }
}
