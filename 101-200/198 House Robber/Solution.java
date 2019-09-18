# Solution 1
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

# Solution 2
class Solution {
    public int rob(int[] nums) {
        int robEven = 0, robOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                robOdd = Math.max(robEven, robOdd + nums[i]);
            } else {
                robEven = Math.max(robOdd, robEven + nums[i]);
            }
        }

        return Math.max(robEven, robOdd);
    }
}

# Solution 3
class Solution {
    public int rob(int[] nums) {
        int rob = 0, notRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int prevRob = rob;
            int prevNotRob = notRob;
            rob = prevNotRob + nums[i];
            notRob = Math.max(prevRob, prevNotRob);
        }

        return Math.max(rob, notRob);
    }
}
