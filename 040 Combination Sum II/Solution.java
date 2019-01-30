class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, candidates, new ArrayList<>(), target, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] candidates, List<Integer> cur, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            cur.add(candidates[i]);
            dfs(result, candidates, cur, target - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
