class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1)
            return 0;
        if (nums.length < 2)
            return nums[0];

        int robbed0 = 0, robbed1 = 0, robbed = 0, ans = 0;

        for (int i = 0; i < nums.length - 1; ++i) {
            robbed = Math.max(robbed0 + nums[i], robbed1);
            robbed0 = robbed1;
            robbed1 = robbed;
        }
        ans = robbed;
        robbed0 = 0;
        robbed1 = 0;
        for (int i = 1; i < nums.length; ++i) {
            robbed = Math.max(robbed0 + nums[i], robbed1);
            robbed0 = robbed1;
            robbed1 = robbed;
        }
        return Math.max(ans, robbed);
    }
}
