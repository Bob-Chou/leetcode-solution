class Solution {
    public int longestArithSeqLength(int[] A) {

        if (A.length < 1)
            return 0;

        Map<Integer, Integer>[] dp = new HashMap[A.length];
        int ans = 1;
        for (int i = 0; i < A.length; ++i) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                int diff = A[i] - A[j];
                int prevLen = dp[j].getOrDefault(diff, 1);
                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 1), prevLen + 1));
                if (dp[i].get(diff) > ans)
                    ans = dp[i].get(diff);
            }
        }
        return ans;
    }
}
