class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] helper = new int[m][nums.length];
        int[] rightSum = new int[nums.length+1];

        for (int i = 0; i < nums.length; ++i)
            rightSum[nums.length-i-1] = rightSum[nums.length-i] + nums[nums.length-i-1];
        for (int i = 0; i < m; ++i) {
            for (int j = i; j < nums.length; ++j) {
                if (i == 0) {
                    if (j == 0) helper[i][j] = nums[j];
                    else helper[i][j] = helper[i][j-1] + nums[j];
                } else {
                    int minMax = Integer.MAX_VALUE;
                    for (int k = i; k <= j; ++k) {
                        int min = Math.max(helper[i-1][k-1], rightSum[k] - rightSum[j+1]);
                        if (min < minMax)
                            minMax = min;
                    }
                    helper[i][j] = minMax;
                }
            }
        }

        return helper[m-1][nums.length-1];
    }
}
