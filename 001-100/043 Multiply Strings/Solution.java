class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int i, j, carry, product;
        int[] num3 = new int[len1 + len2];

        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + num3[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }
        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < num3.length && num3[i] == 0) {
            i++;
        }
        while (i < num3.length) {
            sb.append(num3[i]);
            i++;
        }
        return sb.toString();
    }
}
