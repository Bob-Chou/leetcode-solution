class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int cache = nums[0];
        int unique = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != cache) {
                nums[unique++] = nums[i];
                cache = nums[i];
            }
        }
        return unique;
    }
}
