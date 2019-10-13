# Solution 1
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int result = n + 1;
        int temp = 0;

        for (int i = 0, j = 0; j < n; j++) {
            temp += nums[j];
            while (temp >= s) {
                result = Math.min(result, j - i + 1);
                temp -= nums[i];
                i++;
            }
        }

        return result != n + 1 ? result : 0;
    }
}

# Solution 2
class Solution {
     public int minSubArrayLen(int s, int[] nums) {
         int n = nums.length;
         int result = n;
         int temp = 0;

         for (int i = 0, j = 0; j < n; j++) {
             temp += nums[j];
             while (temp >= s) {
                 while (i <= j && temp - nums[i] >= s) {
                     temp -= nums[i];
                     i++;
                 }
                 result = Math.min(result, j - i + 1);
             }
         }

         return temp >= s ? result : 0;
     }
}
