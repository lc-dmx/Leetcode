class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
    
//     public int trap(int[] height) {
//         Stack<Integer> stack = new Stack<>();
//         int result = 0;
//         int length = height.length;
//         int i = 0;
//         while (i < length) {
//             while (!stack.empty() && height[i] > height[stack.peek()]) {
//                 int top = stack.peek();
//                 stack.pop();
//                 if (stack.empty()) {
//                     break;
//                 }
//                 int distance = i - stack.peek() - 1;
//                 int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
//                 result += distance * bounded_height;
//             }
//             stack.push(i);
//             i++;
//         }
//         return result;
//     }

//     public int trap(int[] height) {
//         if (height == null || height.length < 2) {
//             return 0;
//         }

//         int length = height.length;
//         int result = 0;

//         int[] leftMaxHeight = new int[length];
//         int[] rightMaxHeight = new int[length];
//         leftMaxHeight[0] = height[0];
//         rightMaxHeight[length - 1] = height[length - 1];

//         for (int i = 1; i < length; i++) {
//             leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
//         }

//         for (int i = length - 2; i >= 0; i--) {
//             rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
//         }

//         for (int i = 1; i < length - 1; i++) {
//             result += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
//         }
//         return result;
//     }
}
