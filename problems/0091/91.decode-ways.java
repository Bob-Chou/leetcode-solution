class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+2];
        dp[0] = 0;
        dp[1] = 1;
        int prevCode = 0;
        for (int i = 0; i < s.length(); ++i) {
            int code = s.charAt(i) - '0';
            if (code != 0)
                dp[i+2] += dp[i+1];
            if (prevCode != 0 && prevCode * 10 + code <= 26)
                dp[i+2] += dp[i];
            if (dp[i+2] == 0)
                return 0;
            prevCode = code;
        }
        return dp[s.length()+1];
    }
}
