class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return (double)1;
        }

        long newN = Math.abs((long)n);
        double result = 1;

        while (newN > 0) {
            if ((newN & 1) == 1) {
                result *= x;
            }
            x *= x;
            newN = newN >> 1;
        }

        return n > 0 ? result : 1 / result;
    }
}
