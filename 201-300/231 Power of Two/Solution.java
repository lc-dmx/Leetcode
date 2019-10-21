# Solution 1
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n != Integer.MIN_VALUE && n != 0 && (n & (n - 1)) == 0;
    }
}

# Solution 2
class Solution {
    public boolean isPowerOfTwo(int n) {
       if (n == 0) return false;
       while ((n & 1) == 0) {
           n >>= 1;
       }
       return n == 1;
    }
}
