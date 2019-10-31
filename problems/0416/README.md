# Problem 416
## Review log
+ 05/01/2019 AC

## Insight
This problem equals to find whether exists a sub-array in `nums` summed up to target `sum(nums)/2`. Notice that we could use recursion to solve this question to avoid traversing the whole DP array.
```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        if(sum%2!=0) return false;
        return helper(nums, nums.length-1, sum/2);
    }
    
    private boolean helper(int[] nums, int i, int sum) {
        if(sum == 0) return true;
        else if(i < 0 || sum < 0 || sum < nums[i]) {
            return false;
        }
        else {
            return helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
        }
    }
}
```
