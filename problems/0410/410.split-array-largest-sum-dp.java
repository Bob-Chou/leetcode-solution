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
                    int start = i, end = j+1;
                    while (start < end) {
                        int mid = (start + end) / 2;
                        if (helper[i-1][mid-1] == rightSum[mid] - rightSum[j+1]) {
                            minMax = helper[i-1][mid-1];
                            break;
                        } else if (helper[i-1][mid-1] < rightSum[mid] - rightSum[j+1]) {
                            start = mid + 1;
                            if (minMax > rightSum[mid] - rightSum[j+1])
                                minMax = rightSum[mid] - rightSum[j+1];
                        } else {
                            end = mid - 1;
                            if (minMax > helper[i-1][mid-1])
                                minMax = helper[i-1][mid-1];
                        }
                    }
                    helper[i][j] = minMax;
                }
            }
        }

        return helper[m-1][nums.length-1];
    }
}
