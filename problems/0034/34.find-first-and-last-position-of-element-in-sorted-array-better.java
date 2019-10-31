class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;
        int start = 0;
        int end = nums.length - 1;
        // search left boundary
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                left = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // search right boundary
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                right = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[] {left, right};
    }
}
