class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2]> target) {
                    break;
                }

                if (nums[i] + nums[j]  + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                int target2 = target - nums[i] - nums[j];
                int k = j + 1;
                int l = length - 1;

                while (k < l) {
                    if (nums[k] + nums[l] == target2) {

                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;
                        //Second time remove duplicate
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                    } else if (nums[k] + nums[l] < target2) {
                        k++;
                    } else if (nums[k] + nums[l] > target2) {
                        l--;
                    }
                }
            }

        }

        return result;
    }
}
