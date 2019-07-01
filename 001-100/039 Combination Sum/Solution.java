class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, candidates, new ArrayList<>(), target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, List<Integer> cur, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || idx == candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(result, candidates, cur, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
