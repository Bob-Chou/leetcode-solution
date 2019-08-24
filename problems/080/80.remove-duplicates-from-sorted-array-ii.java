class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int left = 1;
        int right = 1;
        int cnt = 2;
        while (right < nums.length) {
            if (nums[right] != nums[right-1])
                cnt = 1;
            if (cnt++ <= 2) {
                nums[left++] = nums[right];
            }
            ++right;
        }
        return left;
    }
}
