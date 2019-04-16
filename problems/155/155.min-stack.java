class MinStack {

    Stack<int[]> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        min=Math.min(x, min);
        stack.push(new int[]{x, min});
    }

    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
        //reset
        min= stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return min;
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
