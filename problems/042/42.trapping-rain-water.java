class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int volumn = 0;
        int right = height.length - 1, left = 0, leftBar = height[left], rightBar = height[right];
        while (left < right - 1) {
            while (leftBar <= rightBar) {
                if (height[++left] < leftBar)
                     volumn += leftBar - height[left];
                else
                    leftBar = height[left];
                if (left >= right - 1)
                    break;
            }
            while (rightBar < leftBar) {
                if (height[--right] < rightBar)
                     volumn += rightBar - height[right];
                else
                    rightBar = height[right];
                if (left >= right - 1)
                    break;
            }
        }
        return volumn;
    }
}
