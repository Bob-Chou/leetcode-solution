class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            /** four cases that we could skip this position:
             *  1. nums[i] is negative
             *  2. nums[i] is larger than length of nums (answer should be less than the length of this array)
             *  3. nums[i] is in the right position, that is nums[i] == i + 1
             *  4. nums[i] equals to the current number in nums[i]'s right position
             */
            if (nums[i] <= 0 ||
                nums[i] > nums.length ||
                nums[i] == i + 1 ||
                nums[i] == nums[nums[i] - 1]) {
                ++i;
            } else {
                // Swap nums[i] with the number in the correct position of nums[i]
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
