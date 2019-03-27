class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0) {
            return 0;
        }
        while (true) {
            while (nums[right] == val && left < right) {
                --right;
            }
            while (nums[left] != val && left < right) {
                ++left;
            }
            if (left >= right) {
                break;
            } else {
                int swap = nums[right];
                nums[right] = nums[left];
                nums[left] = swap;
            }
        }
        if (nums[left] == val) {
            return left;
        } else {
            return left + 1;
        }
    }
}
