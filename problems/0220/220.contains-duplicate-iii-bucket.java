class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;

        int minNum = Integer.MAX_VALUE;
        for (int n : nums) {
            if (minNum > n)
                minNum = n;
        }
        HashMap<Long, Integer> bucket = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i > k && bucket.containsKey(bucketIndex(nums[i-k-1], minNum, t)))
                bucket.remove(bucketIndex(nums[i-k-1], minNum, t));

            int n = nums[i];
            long idx = bucketIndex(n, minNum, t);
            if (bucket.containsKey(idx-1) && Long.valueOf(n) - Long.valueOf(bucket.get(idx-1)) <= t)
                return true;
            if (bucket.containsKey(idx+1) && Long.valueOf(bucket.get(idx+1)) - Long.valueOf(n) <= t)
                return true;
            if (bucket.containsKey(idx))
                return true;
            bucket.put(idx, n);
        }

        return false;
    }

    private long bucketIndex(int value, int min, int t) {
       return (Long.valueOf(value) - Long.valueOf(min)) / (Long.valueOf(t) + 1);
    }
}
