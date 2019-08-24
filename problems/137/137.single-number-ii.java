class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int tmp = 0;
            for (int n : nums) {
                tmp += (n >> i) & 1;
            }
            if (tmp % 3 == 1)
                ans |= 1 << i;
        }
        return ans;
    }
}
