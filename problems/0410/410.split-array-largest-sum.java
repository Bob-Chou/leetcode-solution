class Solution {
    public int splitArray(int[] nums, int m) {
        long[] arrSum = new long[nums.length+1];
        int arrMax = Integer.MIN_VALUE;

        // arrSum[i+1] stores sum from  nums[0] to nums[i]
        // for getting sum from nums[i] to nums[j] more effectively
        for (int i = 0; i < nums.length; ++i) {
            arrSum[i+1] = nums[i] + arrSum[i];
            if (nums[i] > arrMax)
                arrMax = nums[i];
        }

        // included
        long start = arrMax;
        // excluded
        long end = arrSum[arrSum.length-1] + 1;
        long ans = arrSum[arrSum.length-1];
        while (start < end) {
            long mid = (start + end) / 2;
            boolean validSplit = attempSplit(arrSum, m, mid);
            if (validSplit) {
                end = mid;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }

        return (int) ans;
    }

    public boolean attempSplit(long[] sum, int m, long k) {
        // end point (included) of last split
        int breakpoint = 0;
        int nextBreakpoint = breakpoint;
        while (m > 1) {
            // greedy to get next split
            // each time check the sum from (breakpoint + 1) to middle of possible interval
            int start = breakpoint + 1;
            int end = sum.length;
            while (start < end) {
                int mid = (start + end) / 2;
                if (sum[mid] - sum[breakpoint] < k) {
                    start = mid + 1;
                    nextBreakpoint = mid;
                } else if (sum[mid] - sum[breakpoint] > k) {
                    end = mid;
                } else {
                    nextBreakpoint = mid;
                    break;
                }
            }
            breakpoint = nextBreakpoint;
            --m;
        }
        return sum[sum.length-1] - sum[breakpoint] <= k;
    }
}
