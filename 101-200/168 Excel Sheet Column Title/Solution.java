class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int reminder = n % 26;
            n = n / 26;
            if (reminder == 0) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char)('A' + reminder - 1));
            }
        }

        return sb.reverse().toString();
    }
}
