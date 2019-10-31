class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m];
        for(int i = 0; i < n; i++){
            int prev = 1;
            for(int j = 0; j < m; j++){
                int temp = dp[j];
                if(s.charAt(i) == t.charAt(j)){
                    dp[j] += prev;
                }
                prev = temp;
            }
        }

        return dp[m-1];
    }
}
