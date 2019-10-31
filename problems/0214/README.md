# Problem 214
## Review log
+ 09/18/2019 Use Longest-Palidrome method.

## Insight
### KMP algorithm
This problem is equivalent to finding the longest palidrome prefix. We could convert it to KMP problem. If we revert the string and concatenated to its end, and the last value of next array in KMP is the longest palidrome prefix.
