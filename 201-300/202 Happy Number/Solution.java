# Solution 1
class Solution {
    public boolean isHappy(int n) {
        while (n > 1) {
            if (n == 4) {
                return false;
            }
            int result = 0;
            while (n != 0) {
                int temp = n % 10;
                result += temp * temp;
                n /= 10;
            }
            n = result;
        }
        return true;
    }
}

# Solution 2
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                int temp = n % 10;
                result += temp * temp;
                n /= 10;
            }
            if (set.contains(result)) {
                return false;
            }
            n = result;
            set.add(result);
        }
        return true;
    }
}
