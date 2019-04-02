class Solution {
    public boolean canJump(int[] nums) {
        int farthestReach = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (farthestReach >= i) {
                farthestReach = Math.max(nums[i] + i, farthestReach);
            } else {
                return false;
            }
        }
        return true;
    }
}
