class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                if (helper(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
