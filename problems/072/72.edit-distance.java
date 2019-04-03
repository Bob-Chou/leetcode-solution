class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int dp[][] = new int[l1+1][l2+1];
        for (int i = 0; i < l1 + 1; ++i) {
            for (int j = 0; j < l2 + 1; ++j) {
                if (i == 0) dp[i][j] = j;
                if (j == 0) dp[i][j] = i;
                if (i > 0 && j > 0) {
                    int minStep = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
                    minStep =  Math.min(minStep, dp[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1)?0:1));
                    dp[i][j] = minStep;
                }
            }
        }
        return dp[l1][l2];
    }
}
