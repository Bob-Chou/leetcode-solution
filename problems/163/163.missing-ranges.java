class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long start = lower;
        List<String> ans = new ArrayList<>();
        for (int n : nums) {
            if (start < n) {
                if (start == n - 1) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(String.format("%d->%d", start, n-1));
                }
            }
            start = (long) n + 1;
        }

        if (start < upper) {
            ans.add(String.format("%d->%d", start, upper));
        } else if (start == upper) {
            ans.add(String.valueOf(start));
        }
        return ans;
    }
}
