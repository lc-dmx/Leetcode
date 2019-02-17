class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permutation(result, nums, 0);
        return result;
    }

    private void permutation(List<List<Integer>> result, int nums[], int start) {
        if (start == nums.length - 1) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int i= 0; i < nums.length; i++) {
                array.add(nums[i]);
            }
            if (!result.contains(array)) {
                result.add(array);
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[start]) {
                swap(nums, i, start);
                permutation(result, nums, start + 1);
                swap(nums, i, start);
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
