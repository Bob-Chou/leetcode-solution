class Solution {
    public int mergeStones(int[] stones, int K) {
        if (K == 0)
            return 0;
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0)
            return -1;
        // compute prefix sum for later use
        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = stones[i-1] + prefixSum[i-1];
        }
        // do[i][j] represents the minimal cost after merging range i ~ j as many
        // steps as possible (until we cannot merge further). Therefore for span i~j,
        // after merging, it will remains (j-i) % (K-1) + 1 piles. For example,
        // when we merge [..., 3, 4, 5, 6, ...] from 2 to 5 with K=3, we will leave
        // 2 piles [12, 6] with cost 12.
        int[][] dp = new int[stones.length][stones.length];
        for (int r = 0; r < n; ++r) {
            for (int l = r - K + 1; l >= 0; --l) {
                int max = Integer.MAX_VALUE;
                for (int p = r; p > l; p -= K - 1) {
                    // We can consider merging a larger range as merging the left
                    // part as many as possible, and merging right part to 1 (and
                    // the length of right part should have limitation), and add
                    // the two parts cost, and check if we could merge the collection
                    // remainig iterms of two parts further to 1 item.
                    //
                    // Here we let the right part p ~ r to merge to 1 pile and
                    // let l ~ p-1 to merge as many as possible. In this way, we
                    // merge l ~ r with pivot p (remaining 1 pile + piles left remained)
                    // (in most case, we have done merge l ~ r, except if l ~ p-1
                    // could merge to K-1 piles, if so, we need to do an extra merge)
                    max = Math.min(max, dp[l][p-1] + dp[p][r]);
                    dp[l][r] = max;
                }
                // That's when we do extra merge if we could continue to merge
                // This merge will cost the sum of all stones in that range
                if ((r-l) % (K-1) == 0)
                    dp[l][r] += prefixSum[r+1] - prefixSum[l];
            }
        }
        return dp[0][n-1];
    }
}
