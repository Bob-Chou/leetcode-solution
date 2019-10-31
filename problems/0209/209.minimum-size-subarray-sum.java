class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length < 1)
            return 0;
        int ans = 0;
        int left = -1, right = -1;
        while (right < nums.length) {
            // adjust right boundary
            for (; s > 0 && ++right < nums.length; s -= nums[right]);
            if (s > 0)
                break;
            if (ans == 0 || ans > right - left)
                ans = right - left;
            // adjust left boundary
            s += nums[++left];
        }
        return ans;
    }
}
