class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<List<Integer>> result = new ArrayList<>();
        dfs(result, candidates, new ArrayList<>(), n, 0, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, List<Integer> cur, int target, int idx, int k) {
        if (cur.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
                return;
            } else {
                return;
            }
        }

        for (int i = idx; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            cur.add(candidates[i]);
            dfs(result, candidates, cur, target - candidates[i], i + 1, k);
            cur.remove(cur.size() - 1);
        }
    }
}
