# Problem 44
## Review log
+ 08/13/2019 use dp. Not the best solution

## Insight
Two pointer linear time complexity solution.
```java
class Solution {
    public boolean isMatch(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        int i = 0;
        int j = 0;
        int start = -1;
        int stmp = -1;
        while (i < t.length) {
            if (j < p.length && (p[j] == '?' || t[i] == p[j])) {
                j++;
                i++;
            } else if (j < p.length && p[j] == '*') {
                // record the start of *, for redirect use.
                start = j;
                // record the ending of matched substring in t
                stmp = i;
                j++;
            } else if (start == -1){
                return false;
            }  else {
                // not matching, redict to * and rematch
                j = start + 1;
                i = stmp + 1;
                stmp = i;
            }
        }

        for (int k = j; k < p.length; k++) {
            if (p[k] != '*') return false;
        }
        return true;
    }
}
```
