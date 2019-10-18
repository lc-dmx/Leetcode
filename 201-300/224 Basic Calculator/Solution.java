class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(ch)) {
                    num = 10 * num + (ch - '0');
                    i++;
                    if (i < s.length()) {
                        ch = s.charAt(i);
                    } else {
                        break;
                    }
                }
                result += num * sign;
                i--;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result;
    }
}
