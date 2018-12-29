class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        if (nums == null) {
            return result;
        }

        int length = nums.length;

        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int temp;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            //First time remove duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                temp = nums[j] + nums[k] + nums[i];
                if (temp == target) {

                    return target;

                } else if (temp < target) {
                    if (target - temp < closest) {
                        result = temp;
                        closest = target - result;
                    }
                    j++;
                } else {
                    if (temp - target < closest) {
                        result = temp;
                        closest = result - target;
                    }
                    k--;
                }
            }

        }

        return result;
    }
}
