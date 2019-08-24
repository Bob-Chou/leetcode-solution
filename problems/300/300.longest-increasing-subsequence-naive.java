class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int maxLength = 1;
        int[] helper = new int[nums.length];
        helper[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            helper[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (helper[j] + 1 > helper[i] && nums[j] < nums[i]) {
                    helper[i] = helper[j] + 1;
                }
            }
            if (helper[i] > maxLength) maxLength = helper[i];
        }
        return maxLength;
    }
}
