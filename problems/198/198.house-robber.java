class Solution {
    public int rob(int[] nums) {
        int[] helper = new int[nums.length + 2];
        for (int i = 0; i < nums.length; ++i) {
            helper[i + 2] = Math.max(helper[i]+nums[i], helper[i+1]);
        }
        return helper[nums.length + 1];
    }
}
