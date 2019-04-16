class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int[] minHelper = new int[nums.length + 1];
        int[] maxHelper = new int[nums.length + 1];
        minHelper[0] = 1;
        maxHelper[0] = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0) {
                maxHelper[i+1] = maxHelper[i] > 0 ? maxHelper[i] * nums[i] : nums[i];
                minHelper[i+1] = minHelper[i] <= 0 ? minHelper[i] * nums[i] : nums[i];
            } else {
                maxHelper[i+1] = minHelper[i] <= 0 ? minHelper[i] * nums[i] : nums[i];
                minHelper[i+1] = maxHelper[i] > 0 ? maxHelper[i] * nums[i] : nums[i];
            }
            if (maxHelper[i+1] > ans) ans = maxHelper[i+1];
        }
        return ans;
    }
}
