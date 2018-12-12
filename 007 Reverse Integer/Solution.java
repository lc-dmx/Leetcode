class Solution {
    public int reverse(int x){
        if (x == 0) return 0;
        
        boolean flag = x > 0 ? true : false;
        x = flag ? x : x * (-1);
        
        long result = 0L;
        while (true) {
            int last = x % 10;
            result = result * 10 + last;
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        
        result = flag ? result : result * (-1);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int)result;
    }
}
