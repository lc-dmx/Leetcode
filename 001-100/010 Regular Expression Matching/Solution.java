class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            return ((!s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)))
                    && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));

        } else {
            return !s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                    && isMatch(s.substring(1), p.substring(1));
        }
    }
}        
        
        
class Solution{        
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // the first column is always false
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = false;
        }

        // for the first row, if exists *, it's equal to dp[0][j-2]
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = j > 1 && dp[0][j - 2];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) && dp[i - 1][j];

                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
                }

            }
        }
        return dp[sLen][pLen];
    }
}
