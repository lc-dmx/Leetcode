class Solution {
    public int maximalRectangle(char[][] matrix) {
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
            result = Math.max(result, largestRectangleArea(height));
        }

        return result;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? -1 : heights[i];
            while (!stack.empty() && current <= heights[stack.peek()]) {
                int j = stack.pop();
                result = Math.max(result, heights[j] * (stack.empty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }

        return result;
    }
}
