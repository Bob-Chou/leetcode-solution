class Solution {
    public boolean canJump(int[] nums) {
        int[] reach = new int[nums.length];
        reach[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            reach[i] = reach[i - 1] >= i ? Math.max(nums[i] + i, reach[i - 1]) : reach[i - 1];
        }
        return reach[nums.length - 1] >= nums.length - 1;
    }
}
