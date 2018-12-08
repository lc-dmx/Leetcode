class Solution {

    public String longestPalindrome(String s) {
//dp
        String result = "";
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int start = 0, end = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j - i < 3) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                if (dp[i][j] && (end - start < j - i)) {
                    start = i;
                    end = j;
                }
            }
        }
        result = s.substring(start, end + 1);
        return result;

        
        
// Expand Around Center
//         int start = 0, end = 0;
//             for (int i = 0; i < s.length(); i++) {
//                 int len1 = expandAroundCenter(s, i, i);
//                 int len2 = expandAroundCenter(s, i, i + 1);
//                 int len = Math.max(len1, len2);
//                 if (len > end - start) {
//                     start = i - (len - 1) / 2;
//                     end = i + len / 2;
//                 }
//             }
//             return s.substring(start, end + 1);
//         }

//         private int expandAroundCenter(String s, int left, int right) {
//             int L = left, R = right;
//             while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//                 L--;
//                 R++;
//             }
//             return R - L - 1;
//         }
