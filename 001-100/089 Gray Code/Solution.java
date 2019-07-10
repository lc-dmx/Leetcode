class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(result, n);
        return result;
    }

    private void dfs(List<Integer> result, int n) {
        if (n == 0) {
            result.add(0);
            return;
        }
        dfs(result, n - 1);
        int size = result.size();
        for (int i = size - 1; i >= 0; i--) {
            result.add(result.get(i) + (int)Math.pow(2, n - 1));
        }
    }
}
