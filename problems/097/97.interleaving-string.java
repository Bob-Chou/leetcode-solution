class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // boolean dp[i][j]: whether it's possible to form the substring with
        // first (i+j+2) characters of s3 by using first i characters of s1 and j
        // characters of s2. So the transition function:
        // dp[i][j] = dp[i][j-1] && s3[i+j+1] == s2[j] || dp[i-1][j] && s3[i+j+1] == s1[i]

        if (s1.length() + s2.length() != s3.length())
            return false;

        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length() + 1; ++i) {
            for (int j = 0; j < s2.length() + 1; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j > 0)
                        dp[i][j] |= dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1);
                    if (i > 0)
                        dp[i][j] |= dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
