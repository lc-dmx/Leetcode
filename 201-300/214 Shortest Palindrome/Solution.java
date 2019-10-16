# Solution 1 Two pointers and recursion
class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        int i = 0;
        for (int j = len - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }

        if (i == len) {
            return s;
        }
        String temp = s.substring(i);
        String tempReverse = new StringBuilder(temp).reverse().toString();
        return tempReverse + shortestPalindrome(s.substring(0, i)) + temp;
    }
}

# Solution 2 KMP
class Solution {
    public String shortestPalindrome(String s) {
        String sReverse = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + sReverse;
        int len = temp.length();
        int[] next = new int[len];
        for (int i = 1; i < len; i++) {
            int j = next[i - 1];
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = next[j - 1];
            }
            j += (temp.charAt(i) == temp.charAt(j)) ? 1 : 0;
            next[i] = j;
        }
        return sReverse.substring(0, s.length() - next[temp.length() - 1]) + s;
    }
}
