class Solution {
    public String intToRoman(int num) {
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder result = new StringBuilder();

        int i = value.length - 1;

        while (i > -1) {
            if (num < value[i]) {
                i--;
            } else {
                num = num - value[i];
                result.append(symbol[i]);
            }
        }
        return result.toString();
    }
}
