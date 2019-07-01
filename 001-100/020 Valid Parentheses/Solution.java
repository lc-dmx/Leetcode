class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ) {
                stack.push(s.charAt(i));
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}
