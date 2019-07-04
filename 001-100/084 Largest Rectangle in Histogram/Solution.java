# Solution 1
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? 0 : heights[i];
            while (!stack.empty() && current <= heights[stack.peek()]) {
                int j = stack.pop();
                result = Math.max(result, heights[j] * (stack.empty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }

        return result;
    }
}

# Solution 2
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }

            int minHeight = heights[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                result = Math.max(result, minHeight * (i - j + 1));
            }

        }

        return result;
    }
}
