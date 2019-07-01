Solution 1: The idea is to keep adding each integer to the sequence until the sum drops below 0. If sum is negative, then we should reset the sequence.

Time complexity: O(n)
Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;

        for(int n : nums) {
            sum = Math.max(n, sum + n);
            max= Math.max(max, sum);
        }
        return max;
    }
}

Solution 2: DP

Time complexity: O(n)
Space Complexity: O(n)

class Solution {
	public int maxSubArray(int[] A) {
        int[] dp = new int[A.length];		// dp[i] is the maximum subarray ending with A[i];
        int maxSum = dp[0] = A[0];
        
        for (int i = 1; i < A.length; i++) {
            dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}

Solution 3: Divide and Conquer

This is the divide and conquer solution.

1. The total problem is divided into three parts, find the max sum in the left partition , the max sum in the right partition and the crossing sum.
2. For the crossing sum, Since it must contains the mid element, so we just need to find the max suffix of its left partation and max prefix of its right partition, and add them together.
3. The base case here is left is equal to right, we should just return the value;(Easy way to think about the base case is to test your solution with array size equal to 2 and 3 )
4. Time complexity is O(n logn ), the same as merge sort algorithm.

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0 ; 
        return maxSubArrayHelper(nums,0,nums.length-1);
    }
    
    private  int maxCrossingArray(int[] nums, int left, int mid , int right){
        int sum = 0;
        
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        
        for(int idx = mid; idx>=left; idx --){
            sum += nums[idx];
            leftSum = Math.max(sum,leftSum);
        }
        
        sum = 0;
        
        for(int idx = mid+1; idx<=right; idx++){
            sum += nums[idx];
            rightSum = Math.max(sum,rightSum);
        }
        
        return leftSum + rightSum;
    }
    
    private int maxSubArrayHelper(int[] nums,int left, int right){
        if(left == right ) return nums[left];
        int mid = left + (right-left) /2 ;
        return Math.max(Math.max(maxSubArrayHelper(nums,left,mid),
                                 maxSubArrayHelper(nums,mid+1,right)),maxCrossingArray(nums,left,mid,right));
    }
}

[Reference](https://leetcode.com/problems/maximum-subarray/discuss/232505/Java-Solution%3A-Divide-and-Conquer-way-and-Dynamic-programming-way)
