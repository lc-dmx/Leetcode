public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 1) {
            return null;
        }

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (integerMap.containsKey(nums[i])) {
                return new int[] {i, integerMap.get(nums[i])};
            }

            //If we can't find, add the corresponding number and the position to the map
            integerMap.put(target - nums[i], i);
        }
        return null;
    }
}
