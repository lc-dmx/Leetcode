class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            result = 26 * (result + s.charAt(i) - 'A' + 1);
        }

        result += s.charAt(s.length() - 1) - 'A' + 1;
        return result;
    }
}
