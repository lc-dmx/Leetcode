class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        int length = nums.length;

        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);

        if (nums[length - 1] < 0 || nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            
            //First time remove duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                if (nums[j] + nums[k] == 0 - nums[i]) {

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                    //Second time remove duplicate
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                } else if (nums[j] + nums[k] < 0 - nums[i]) {
                    j++;
                } else if (nums[j] + nums[k] > 0 - nums[i]) {
                    k--;
                }
            }

        }

        return result;
    }
}
