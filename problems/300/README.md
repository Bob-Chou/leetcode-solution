# Problem 11
## Review log
+ 04/25/2019 Fail to reach the optimum solution. 

## Insight
The binary search method might be little tricky. We maintain a `dp` array which stores the current longest sequence. For ith number `nums[i]` in the number array, we use binary search to find its correct position to form a longest ascending sequence. That is, given a new number `nums[i]`, we search in `dp` from `0` to `maxLength`and find the first number which is greater than it, and replace that number (**this does not necessarily mean it currently form a required sequence, but if it could form one later, it must be in this position**). If this number should be inserted in the end of this array, it might append this sequence and let our `maxLength += 1`
```java
public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
        int i = Arrays.binarySearch(dp, 0, len, num);
        if (i < 0) {
            i = -(i + 1);
        }
        dp[i] = num;
        if (i == len) {
            len++;
        }
    }
    return len;
}
```
