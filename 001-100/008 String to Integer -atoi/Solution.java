class Solution {
        public int myAtoi(String str){
        if (str == null) {
            return 0;
        }
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        boolean flag = true;
        int i = 0;

        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            flag = false;
            i++;
        }

        long num = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) >'9') {
                break;
            }
            num = num * 10 + (str.charAt(i) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }

        if (flag && num >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (!flag && num * (-1) <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return flag ? (int) num : (int)num * (-1);
    }
}
