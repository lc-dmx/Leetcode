public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;
            result <<= 1;
            result += temp;
            n >>= 1;
        }

        return result;
    }
    
    // public int reverseBits(int n) {
    //     StringBuilder sb = new StringBuilder();
    //     String temp = Integer.toBinaryString(n);
    //     for (int i = 0; i < temp.length(); i++) {
    //         sb.append(temp.charAt(i));
    //     }
    //     sb.reverse();
    //     while (sb.length() != 32) {
    //         sb.append('0');
    //     }
    //     long result = Long.valueOf(sb.toString(), 2);
    //     if (result > Integer.MAX_VALUE) {
    //         result = -(~result + 1);
    //     }
    //     return (int)result;
    // }
}
