class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!helper(s.charAt(start))) {
                start++;
                continue;
            }
            if (!helper(s.charAt(end))) {
                end--;
                continue;
            }

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean helper(char c) {
        if ((c - 'a' <= 25 && c - 'a' >= 0) || (c - '0' >= 0 && c - '0' <= 9)) {
            return true;
        }
        return false;
    }
}
