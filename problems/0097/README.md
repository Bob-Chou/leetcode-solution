# Problem 97
## Review log
+ 08/11/2019 dp AC.

## Insight
Recursion with memory runs faster than dp (1ms vs 4ms), it's hard to say which is better? (the real time complexity of recursion solution is hard to analyze)
```java
class Solution {
    Set<String> cache = new HashSet<String>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Input Invalid!");
        }
        
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        return isInterleaveHelper(s1, s2, s3, 0, 0, 0);
    }
    
    private boolean isInterleaveHelper(String s1, String s2, String s3, int p1, int p2, int p3) {
        if (p3 == s3.length()) {
            return true;
        }
        if (p1 == s1.length()) {
            return s2.substring(p2).equals(s3.substring(p3));
        }
        if (p2 == s2.length()) {
            return s1.substring(p1).equals(s3.substring(p3));
        }

        // early stop
        if (cache.contains(p1 + "," + p2))  {
            return false;
        }
        
        if (s1.charAt(p1) == s3.charAt(p3)) {
            if (isInterleaveHelper(s1, s2, s3, p1 + 1, p2, p3 + 1)) {
                return true;
            }
        }
        
        if (s2.charAt(p2) == s3.charAt(p3)) {
            if (isInterleaveHelper(s1, s2, s3, p1, p2 + 1, p3 + 1)) {
                return true;
            }
        }

        cache.add(p1 + "," + p2);
        return false;
    }
}
```
