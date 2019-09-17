class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackValue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        stackValue = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (stackValue.isEmpty() || x <= stackValue.peek()) {
            stackValue.push(x);
        }
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == stackValue.peek()) {
            stackValue.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
