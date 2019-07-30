# Solution 1
class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] dp = new int[tLength + 1];
        dp[0] = 1;

        for (int i = 1; i <= sLength; i++) {
            for (int j = tLength; j > 0;j --) {
                dp[j] += (s.charAt(i - 1) == t.charAt(j - 1) ? dp[j - 1] : 0);
            }
        }

        return dp[tLength];
    }
}

# Solution 2
class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[tLength + 1][sLength + 1];

        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= tLength; i++) {
            for (int j = 1; j <= sLength; j++) {
                dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
            }
        }

        return dp[tLength][sLength];
    }
}
