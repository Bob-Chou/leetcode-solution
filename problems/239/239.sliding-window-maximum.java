class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        MaxQueue helper = new MaxQueue();
        for (int i = 0; i < k; ++i) {
            helper.serve(nums[i]);
        }
        ans[0] = helper.getMax();
        for (int i = 1; i < nums.length - k + 1; ++i) {
            helper.poll();
            helper.serve(nums[i + k - 1]);
            ans[i] = helper.getMax();
        }
        return ans;
    }
}

class MaxStack {
    private int max;
    private Stack<Integer> stack;
    public MaxStack() {
        max = Integer.MIN_VALUE;
        stack = new Stack<>();
    }
    public void push(int val) {
        if (val >= max) {
            stack.push(max);
            max = val;
        }
        stack.push(val);
    }
    public int pop() {
        if (stack.peek() == max) {
            int val = stack.pop();
            max = stack.pop();
            return val;
        } else {
            return stack.pop();
        }
    }
    public int getMax() {
        return max;
    }
    public boolean empty() {
        return stack.empty();
    }
}

class MaxQueue {
    private MaxStack pushStack, popStack;
    public MaxQueue() {
        pushStack = new MaxStack();
        popStack = new MaxStack();
    }
    public void serve(int val) {
        pushStack.push(val);
    }
    public int poll() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
    public int getMax() {
        return popStack.getMax() > pushStack.getMax() ? popStack.getMax() : pushStack.getMax();
    }
}
