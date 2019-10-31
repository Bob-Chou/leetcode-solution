class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum[i+1] = sum[i] + nums[i];
        }
        Map<Integer, Integer> helper = new HashMap<>();
        helper.put(0, 1);
        int ans = 0;
        for (int i = 1; i < sum.length; ++i) {
            ans += helper.getOrDefault(sum[i]-k, 0);
            helper.put(sum[i], helper.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }
}
