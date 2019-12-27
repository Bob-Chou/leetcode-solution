class Solution {
    public int maxCoins(int[] nums) {
        int[][] cache = new int[nums.length][nums.length];
        Arrays.fill(cache, -1);
        return maxCoins(nums, 0, nums.length-1, 1, 1);
    }

    public int maxCoins(int[] nums, int[][] cache, int l, int r, int leftMargin, int rightMargin) {
        if (l == r)
            return nums[l] * leftMargin * rightMargin;
        if (l > r)
            return 0;
        if (cache[l][r] != -1)
            return cache[l][r];

        int max = 0;
        for (int i = l; i <= r; ++i) {
            int score = 0;
            // last burst ballon i
            score += leftMargin * nums[i] * rightMargin;
            score += maxCoins(nums, l, i-1, leftMargin, nums[i]);
            score += maxCoins(nums, i+1, r, nums[i], rightMargin);
            cache[l][r] = score;
            if (score > max)
                max = score;
        }

        return max;
    }
}
