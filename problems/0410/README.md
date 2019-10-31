# Problem 410
## Review log
+ 10/16/2019. Fail to resolve it.

## Insight
#### DP
Dynamic programming could be applied to non-aftereffect problems. In this problem, the optimal split in first i-th elements would not be affected by later elements. Let `dp[i][j]` denotes the optimal `i` parts plit of first `j` elements, and we may know `dp[i][j]` from `dp[i-1][j-1]`
#### Binary Search
We know the answer should be within `max(nums) ~ sum(nums)`. Promised that if we could do `m`-split with max sum of `x`, then we could also do that in any numbers less than `x`, we could binary search from `max(nums)` to `sum(nums)`. 

To find if we could do `m`-split with given max sum `x`, we could keep inserting rightmost breakpoints from left to right which guarantee that the sum of newly split numbers is less or equal to `x`. To find the proper position of breakpoint, we could keep binary searching in the left range (from `breakpoint` to `end of nums`):
+ initialize `start = breakpoint; right = nums.length + 1; mid = (right + start)/2`
+ Keep searching until `start == right`
    - if `sum` from `nums[start]` to `nums[mid]` is less than `x`, then we know we still have quota to expand our split area, so that we continue to move rightwards, let `start = mid + 1` and keep searching
    - if `sum` is greater than `x`, then we should shrink our split area, let `end = mid` and keep searching
