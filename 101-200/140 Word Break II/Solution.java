class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if (dp[i]) break;
            }
        }
        if (!dp[s.length()]) return result;
        helper(s, wordDict, "", 0, result);
        return result;
    }

    private void helper(String s, List<String> wordDict, String path, int pos, List<String> result) {
        if (pos == s.length()) {
            result.add(path);
            return;
        }

        if (path.length() != 0) path += " ";
        for (int i = pos; i < s.length(); i++) {
            String str = s.substring(pos, i + 1);
            if (!wordDict.contains(str)) continue;
            helper(s, wordDict, path + str, i + 1, result);
        }
    }
}
