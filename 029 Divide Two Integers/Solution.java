class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        int result = 0;

        while (newDividend >= newDivisor) {
            int shift = 1;
            long tmp = newDivisor;
            while (newDividend >= tmp * 2) {
                tmp = tmp * 2;
                shift = shift * 2;
            }
            newDividend = newDividend - tmp;
            result = result + shift;
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) result = -result;
        return result;
    }
}
