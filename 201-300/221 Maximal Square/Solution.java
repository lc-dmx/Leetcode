# Solution 1 Monotone Stack
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            result = Math.max(result, helper(height));
        }
        return result;
    }

    private int helper(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int temp = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && temp <= height[stack.peek()]) {
                int j = stack.pop();

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                if (height[j] < width) {
                    result = Math.max(result, height[j] * height[j]);
                } else {
                    result = Math.max(result, width * width);
                }
            }
            stack.push(i);
        }

        return result;
    }
}

# Solution 2 DP
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int result = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }

}
