class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length < 1)
            return 0;
        int[] helper = new int[2 * nums.length + 1];
        int sum = nums.length + 2*nums[0] - 1;
        helper[sum] = 0;
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            sum += 2*nums[i] - 1;
            if (sum == nums.length)
                ans = i+1 > ans ? i+1 : ans;
            if (helper[sum] != 0) {
                ans = i - helper[sum] > ans ? i - helper[sum] : ans;
            } else {
                helper[sum] = i;
            }
        }
        return ans;
    }
}
