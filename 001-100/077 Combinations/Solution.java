class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(result, new ArrayList<>(), nums, k, 0);
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
