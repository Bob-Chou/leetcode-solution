# Problem 32
## Review log
+ 06/18/2019 Come up with `O(N^2)` solution.

## Insight
### DP O(N) solution
`dp[n]`denotes the longest valid length end up at `i`th. The transition:
```
dp[i] = 0;
if s[n] == ')' and s[n-1] == '(' then
    // we get a new match after i-2!
    dp[n] = dp[i-2] + 2;
else if s[n] == ')' and s[n-1] == ')' then
    // check if the character before dp[i-1] is '('
    if s[i - dp[n] - 1] = '(' then
        dp[n] = dp[i-1] + dp[i - dp[i-1] - 1] + 2;
```
```java
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        int[] dp = new int[s.length() + 1];
        int maxLength = 0;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < s.length() + 1; ++i) {
            if (s.charAt(i-1) == ')' && s.charAt(i-2) == '(') {
                dp[i] = 2 + dp[i-2];
            } else if (s.charAt(i-1) == ')' && s.charAt(i-2) == ')') {
                if (i - dp[i-1] > 1 && s.charAt(i - dp[i-1] - 2) == '(') {
                    dp[i] = 2 + dp[i-1] + dp[i - dp[i-1] - 2];
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = 0;
            }
            if (dp[i] > maxLength) 
                maxLength = dp[i];
        }
        return maxLength;
    }
}
```
