class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        boolean[][] helper = new boolean[nums.length][sum/2+1];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j <= sum/2; ++j) {
                helper[i][j] = j == 0 || i > 0 && (j >= nums[i] && helper[i-1][j-nums[i]] || helper[i-1][j]);
            }
        }
        return helper[nums.length-1][sum/2];
    }
}
