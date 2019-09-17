class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperation(tokens[i])) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (tokens[i].equals("+")) {
                    result = num1 + num2;
                } else if (tokens[i].equals("-")) {
                    result = num1 - num2;
                } else if (tokens[i].equals("*")) {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperation(String str) {
        if (str.equals("-") || str.equals("+") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }
}
