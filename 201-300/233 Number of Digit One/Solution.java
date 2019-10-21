class Solution {
    public int countDigitOne(int n) {
        int result = 0;
        int a = 1;
        int b = 1;
        while (n > 0) {
            result += (n + 8) / 10 * a;
            result += (n % 10 == 1) ? b : 0;

            b += n % 10 * a;
            a *= 10;

            n /= 10;
        }
        return result;
    }
}
