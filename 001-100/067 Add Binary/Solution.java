class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int i = len1 - 1, j = len2 - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (carry > 0 || i >= 0 || j >= 0) {
            int tmp = 0;
            tmp += i < 0 ? 0 : a.charAt(i) - '0';
            tmp += j < 0 ? 0 : b.charAt(j) - '0';
            tmp += carry;

            if (tmp == 3) {
                result.append(1);
                carry = 1;
            } else if (tmp == 2) {
                result.append(0);
                carry = 1;
            } else if (tmp == 1) {
                result.append(1);
                carry = 0;
            } else {
                result.append(0);
                carry = 0;
            }
            i--;
            j--;
        }

        return result.reverse().toString();
    }
}
