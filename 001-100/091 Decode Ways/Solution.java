# Solution 1

如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们是在第i-2位的解码方法上继续解码。dp[i]=dp[i-1]+dp[i-2]

如果字符串的第i-1位和第i位不能组成有效二位数字，而且第i位不是0的话，说明我们是在第i-1位的解码方法上继续解码。dp[i]=dp[i-1]

class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}

# Solution 2

再来看一种空间复杂度为 O(1) 的解法。用两个变量 a, b 来分别表示 s[i-1] 和 s[i-2] 的解码方法，
然后我们从 i=1 开始遍历，也就是字符串的第二个字符，我们判断如果当前字符为 '0'，说明当前字符不能单独拆分出来，只能和前一个字符一起，我们先将 a 赋为0，
然后我们看前面的字符，如果前面的字符是1或者2时，我们就可以更新 a = a + b，然后 b = a - b，其实 b 赋值为之前的 a，
如果不满足这些条件的话，那么 b = a。

class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int a = 1, b = 1, n = s.length();
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '0') a = 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                a = a + b;
                b = a - b;
            } else {
                b = a;
            }
        }
        return a;
    }
}
