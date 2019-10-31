# Problem 131
## Review log
+ 08/14/2019 AC. 

## Insight
A new method to record palindrome helper to accelerate algorithm
```java
class PalindromeHelper {
    private boolean[][] helper
    public PalindromeHelper (String s) {
        helper = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            getHelper(s, i, i, helper);
            getHelper(s, i, i+1, helper);
        }
    }
    private void getHelper(String s, int l, int r, boolean[][] helper) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            helper[l][r] = true;
            --l;
            ++r;
        }
    }
    public boolean isPalindrome(int start, int end) {
        if (start >= end) {
            return true;
        }
        return helper[start][end];
    }
}
