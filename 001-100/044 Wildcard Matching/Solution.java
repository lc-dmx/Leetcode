public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
        return false;
    }
    int sLen = s.length();
    int pLen = p.length();
    int i = 0, j = 0, sPre = -1, pPre = -1;
    while (i < sLen) {
        if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
            i++;
            j++;
        } else if (j < pLen && p.charAt(j) == '*') {
            sPre = i;
            pPre = j;
            j++;
        } else if (pPre != -1) {
            i = ++sPre;
            j = pPre + 1;
        } else {
            return false;
        }
    }

    while (j < pLen && p.charAt(j) == '*') {
        j++;
    }
    return j == pLen;
}

public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;

    for (int i = p.length() - 1; i >= 0; i--) {
        if (p.charAt(i) == '*') {
            dp[s.length()][i] = true;
        } else {
            break;
        }
    }

    for (int i = s.length() - 1; i >= 0; i--) {
        for (int j = p.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                dp[i][j] = dp[i + 1][j + 1];
            } else if (p.charAt(j) == '*') {
                dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
            } else {
                dp[i][j] = false;
            }
        }
    }
    return dp[0][0];
}
