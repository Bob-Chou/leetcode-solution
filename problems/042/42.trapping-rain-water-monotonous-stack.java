class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int volumn = 0;
        Stack<int[]> bars = new Stack<>();
        bars.push(new int[] {height[0], 0});
        for (int i = 1; i < height.length; ++i) {
            while (!bars.empty() && bars.peek()[0] <= height[i]) {
                int[] bottom = bars.pop();
                if (!bars.empty()) {
                    int[] left = bars.peek();
                    volumn += (Math.min(left[0], height[i]) - bottom[0]) * (i - left[1] - 1);
                }
            }
            bars.push(new int[] {height[i], i});
        }
        return volumn;
    }
}
