# Problem 128
## Review log
+ 08/12/2019 Use Uinion-Find.

## Insight
Better solution 1: use HashSet purely.
```java
/** Use hash set
 *  Add all number into HashSet and traverse. When visit a number
 *  find the longest sequence containing it and delete all numbers
 *  in this sequence.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
}
```
Better solution 2: use dp.
```java
/** DP
 *  We could concatenate smaller sequence into longer one by using dp.
 *  The dp hashmap record the longest sequence containing n.
 *  Each step, we read the dp[n-1] (if not exists, 0), which means the left
 *  longest sequence (note that this sequence is promised to be ended at n-1, 
 *  and hence the dp[n-1] denotes the left subsequence to be extended) and 
 *  the dp[n+1]. We update dp[n] = dp[n+dp[n+1]] = dp[n-dp[n-1]] = dp[n-1] + dp[n+1] + 1; Then we guarantee that the dp values of both sides of this 
 *  sequence is updated.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> record = new HashMap<>();
        for (int n : nums) {
            if (!record.containsKey(n)) {
                int left = record.getOrDefault(n-1, 0);
                int right = record.getOrDefault(n+1, 0);
                int length = left + 1 + right;
                if (length > ans)
                    ans = length;
                record.put(n, length);
                record.put(n-left, length);
                record.put(n+right, length);
            }
        }
        return ans;
    }
}```

