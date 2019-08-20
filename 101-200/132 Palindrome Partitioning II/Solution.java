class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = s.length() - i - 1;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    dp[i] = (j == s.length() - 1) ? 0 : Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }

        return dp[0];
    }
}
