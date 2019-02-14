class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
                if (curEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}


//    public int jump(int[] nums) {
//        int length = nums.length;
//        int[] dp = new int[length];
//        dp[0] = 0;
//        for (int i = 1; i < length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[length - 1];
//    }
