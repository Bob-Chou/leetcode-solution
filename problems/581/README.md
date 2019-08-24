# Problem 560
## Review log
+ 06/15/2019 AC

## Insight
We could use a state machine for this question. Traverse the array, run our state machine for each step i:

+ state 0: init state
+ state 1: `SubArray` open.
+ state 2: `SubArray` closed.

First, we let `int startOfSubArray = -1; int endOfSubArray = -1; int maxOfSubArray = MIN_VALUE`.

0. We are in `state 0` (init state) and we keep traversing the array to find the first descending point. For each step, we let `startOfSubArray = endOfSubArray = i`. When we find the first descending point, we transfer to `state 1` (`SubArray` open) with the condition `nums[i] < nums[i-1]`
1. Now we are in `state 1`. We need to decide (or reconsider) our boundary of current subarray. First, we scan the array in reverse order from `startOfSubArray`to find the first index where the value is larger than `nums[i]` and assign it to `maxOfSubArray`. We then let `maxOfSubArray = nums[i-1]; endOfSubArray = i + 1;` 
2. If `nums[i] < maxOfSubArray`, we continue to traverse the array, let `endOfSubArray = i + 1`, update the `maxOfSubArray` until we first encounter `nums[i] > maxOfSubArray`.
3. If `nums[i] > maxOfSubArray`, we have transition `state 1 -> state 2` (`SubArray` closed), it means we could close the sub-array now.
4. Keep traversing. Remain in `state 2` if we have `nums[i] < nums[i-1]`. Or it means we meet the next descending piont, and we take transition `state 2 -> state 1`.
4. Repeat step 1 to step 4 until we finish our traversal. The answer should be `endOfSubArray - startOfSubArray`.
