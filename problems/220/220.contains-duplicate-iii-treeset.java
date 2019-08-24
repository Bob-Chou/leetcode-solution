class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            if (i > k)
                bst.remove(nums[i-k-1]);
            Integer ceil = bst.ceiling(nums[i]);
            Integer floor = bst.floor(nums[i]);
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t)
                return true;
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t)
                return true;
            bst.add(nums[i]);
        }
        return false;
    }
}
