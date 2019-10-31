class Solution {
    public int findUnsortedSubarray(int[] nums) {
        /** We use state machine to solve this problem.
         * state 0: init state
         * state 1: SubArray open. After we meet descending breakpoint.
         * state 2: SubArray closed. After we get back to ascending sequence again.
         */
        int maxUnsorted = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        boolean closed = true;
        for (int i = 1; i < nums.length; ++i) {
            if (closed) {
                if (nums[i] < nums[i-1]) {
                    // we meet a descending breakpoint
                    // transfer to state 1
                    closed = false;

                    // if we are now at state 0
                    if (start < 0)
                        start = i-1;

                    // update the left boundary (start)
                    for (int j = start; j >= 0 && nums[j] > nums[i]; --j)
                        start = j;

                    end = i + 1;
                    maxUnsorted = nums[i-1];
                }
            } else {
                if (nums[i] < maxUnsorted) {
                    // stay at state 1
                    end = i + 1;
                    // update the left boundary (start)
                    for (int j = start; j >= 0 && nums[j] > nums[i]; --j)
                            start = j;
                } else {
                    // transfer to state 2
                    closed = true;
                }
            }
        }
        return end - start;
    }
}
