# Problem 560
## Review log
+ 05/03/2019 Fail to solve it.

## Insight
This problem can be converted into problem 1 by introducing helper array. If we use an array to record the sum up to `ith` element in num array, then we can simply derive the sum of subarray `ith` to `jth` by substraction of `sum[j]-sum[i]`. Then our target shifted to find the total number pair with the given target substraction. This target is similiar to problem 1 "Two sum". We can use a hashmap to reduce the time complexity to O(N).
