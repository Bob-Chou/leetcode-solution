class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            curSum += nums[i];
            maxSum = curSum > maxSum ? curSum : maxSum;
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
