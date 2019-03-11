class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int mod = 1;
        for(int i = 1; i <= n; i++){
            nums.add(i);
            mod = mod * i;
        }

        k--;

        for(int i = 0; i < n; i++){
            mod = mod / (n - i);
            int cur = k / mod;
            k %= mod;
            result.append(nums.get(cur));
            nums.remove(cur);
        }
        return result.toString();
    }
}

[Explanation](https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n))
