# Solution 1
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}

# Solution 2
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
         int temp = m;
         int count1 = 0;
         while (temp != 0) {
             temp >>= 1;
             count1++;
         }

         temp = n;
         int count2 = 0;
         while (temp != 0) {
             temp >>= 1;
             count2++;
         }

         if (count1 != count2) {
             return 0;
         }

         int result = m;
         while (m < n) {
             m++;
             result &= m;
         }
         return result;
     }
}
