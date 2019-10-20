class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], end = start;
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                end = nums[i + 1];
                i++;
            }
            result.add(start == end ? String.valueOf(start) : start + "->" + end);
        }
        return result;
    }
}
