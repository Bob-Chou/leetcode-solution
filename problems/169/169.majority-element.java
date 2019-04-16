class Solution {
    public int majorityElement(int[] nums) {
        int top = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cnt == 0) {
                top = nums[i];
                ++cnt;
            } else {
                cnt += nums[i] == top ? 1 : -1;
            }
        }
        return top;
    }
}
