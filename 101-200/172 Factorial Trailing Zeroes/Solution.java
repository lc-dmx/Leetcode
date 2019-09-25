# Solution 1
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}

# Solution 2
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        //用long,否则会溢出
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }

        return count;
    }
}
