class Solution {
    public void nextPermutation(int[] nums) {
        for (int p = nums.length - 1; p > 0; --p) {
            if (nums[p - 1] < nums[p]) {
                int cache = p;
                for (int q = p; q < nums.length; ++q) {
                    if (nums[q] < nums[cache] && nums[q] > nums[p - 1]) {
                        cache = q;
                    }
                }
                int temp = nums[p - 1];
                nums[p - 1] = nums[cache];
                nums[cache] = temp;
                Arrays.sort(nums, p, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
