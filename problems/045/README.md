# Problem 45
## Review log
+ 07/02/2019 AC.

## Insight
Another solution is to process our step-array.
```java
class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        for(int i = 1; i < N; ++i) {
            nums[i] = Math.max(nums[i], nums[i-1] - 1);
        }
        
        int jumps = 0;
        int index = 0;
        while(index < N - 1) {
            ++jumps;
            index+=nums[index];
        }
        
        return jumps;
    }
}
```
