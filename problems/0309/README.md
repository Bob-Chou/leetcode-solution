# Problem 309
## Review log
+ 04/30/2019 Fail to reach the optimum solution.

## Insight
The actions allowed in this question are much more complicated. Use a single DP array might be hard. We can use two arrays to record the process. One denotes the maximum profit of holding the stock at that day, and the other stands for not holding any stock. Then we can update these two arrays together when traversing.
