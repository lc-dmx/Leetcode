class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1 ) {
            return true;
        }

        int curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFarthest;
                if (curEnd >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
