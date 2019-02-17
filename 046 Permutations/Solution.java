class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        permutation(result, nums, start);
        return result;
    }

    private void permutation(List<List<Integer>> result, int nums[], int start) {
        if (start == nums.length - 1) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int i= 0; i < nums.length; i++) {
                array.add(nums[i]);
            }
            result.add(array);
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
