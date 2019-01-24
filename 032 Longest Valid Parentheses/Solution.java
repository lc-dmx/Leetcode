class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
    
//     public int longestValidParentheses(String s) {
//         int result = 0;
//         int left = 0;
//         int right = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 left++;
//             } else {
//                 right++;
//             }
//             if (left == right) {
//                 result = Math.max(result, left + right);
//             } else if (right > left) {
//                 left = right = 0;
//             }
//         }

//         left = right = 0;
//         for (int i = s.length() - 1; i >= 0; i--) {
//             if (s.charAt(i) == '(') {
//                 left++;
//             } else {
//                 right++;
//             }
//             if (left == right) {
//                 result = Math.max(result, left + right);
//             } else if (left > right) {
//                 left = right = 0;
//             }
//         }
//         return result;
//     }
    
//     public int longestValidParentheses(String s) {
//         int result = 0;
//         int[] dp = new int[s.length()];

//         for (int i = 1; i < s.length(); i++) {
//             if (s.charAt(i) == ')') {
//                 if (s.charAt(i - 1) == '(') {
//                     dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                 } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                     dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                 }
//                 result = Math.max(result, dp[i]);
//             }
//         }
//         return result;
//     }
}
