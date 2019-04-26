class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(result, new ArrayList<>(), nums, i, 0);
        }
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> tempList, int[] nums, int k, int pos) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        if (pos >= nums.length) {
            return;
        }

        tempList.add(nums[pos]);
        dfs(result, tempList, nums, k, pos + 1);
        tempList.remove(tempList.size() - 1);
        dfs(result, tempList, nums, k, pos + 1);
    }
}
