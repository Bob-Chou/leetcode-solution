class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> helper = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (helper.empty() || heights[helper.peek()] < heights[i]) {
                helper.push(i);
            }
            else {
                while(!helper.empty()) {
                    if (heights[helper.peek()] >= heights[i]) {
                        int top = helper.pop();
                        int left = helper.empty() ? 0: helper.peek() + 1;
                        max = (i - left) * heights[top] > max ? (i - left) * heights[top] : max;
                    } else {
                        break;
                    }
                }
                helper.push(i);
            }
        }
        while(!helper.empty()) {
            int top = helper.pop();
            int left = helper.empty() ? 0: helper.peek() + 1;
            max = (heights.length - left) * heights[top] > max ? (heights.length - left) * heights[top] : max;
        }
        return max;
    }
}
