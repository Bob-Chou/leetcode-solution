class Solution {
    public int maxArea(int[] height) {
        int maxVolumn = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int volumn = (right - left) * Math.min(height[left], height[right]);
            maxVolumn = volumn > maxVolumn ? volumn : maxVolumn;
            if (height[left] < height[right]){
                ++left;
            } else {
                --right;
            }
        }
        return maxVolumn;
    }
}
