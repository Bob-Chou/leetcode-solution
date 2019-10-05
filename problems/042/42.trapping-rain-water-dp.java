class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int volumn = 0;
        int[] leftBars = new int[height.length], rightBars = new int[height.length];
        leftBars[0] = height[0];
        rightBars[height.length-1] = height[height.length-1];
        for (int i = 1; i < height.length; ++i) {
            leftBars[i] = Math.max(leftBars[i-1], height[i]);
            rightBars[height.length-i-1] = Math.max(rightBars[height.length-i], height[height.length-i-1]);
        }

        for (int i = 1; i < height.length - 1; ++i)
            volumn += Math.min(leftBars[i], rightBars[i]) - height[i];

        return volumn;
    }
}
