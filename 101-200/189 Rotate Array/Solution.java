# Solution 1
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        
        helper(nums, 0, len - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, len - 1);
    }

    private void helper(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

# Solution 2
class Solution {
     public void rotate(int[] nums, int k) {
         int len = nums.length;
         k = k % len;
         int count = 0;
         for (int start = 0; count < len; start++) {
             int current = start;
             int prev = nums[start];
             do {
                 int temp = nums[(current + k) % len];
                 nums[(current + k) % len] = prev;
                 prev = temp;
                 current = (current + k) % len;
                 count++;
             } while (current != start);
         }
     }
}
