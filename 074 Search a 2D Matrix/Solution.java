Solution1:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][col - 1]) {
                result = binarySearch(matrix[i], target, 0, col - 1);
            }
        }

        return result;
    }

    private boolean binarySearch(int[] vector, int target, int low, int high){
        if (high >= low) {
            int mid = (low + high) / 2;
            if (vector[mid] == target) {
                return true;
            } else if (vector[mid] > target) {
                return binarySearch(vector, target, low, mid - 1);
            } else {
                return binarySearch(vector, target, mid + 1, high);
            }
        }
        return false;
    }
}

Solution2:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        for (int i = m - 1, j = 0; i >= 0 && j < n; ) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) j++;
            else i--;
        }
        return false;
    }
}
