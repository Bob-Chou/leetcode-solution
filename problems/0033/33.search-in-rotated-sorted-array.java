class Solution {
    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        int leftBoundary = leftBoundarySearch(nums, 0, nums.length - 1);
        if (target >= nums[0] && target <= nums[leftBoundary]) {
            return binarySearch(nums, target, 0, leftBoundary);
        } else {
            return binarySearch(nums, target, leftBoundary + 1, nums.length - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (nums[middle] < target) {
            return binarySearch(nums, target, middle + 1, end);
        } else if (nums[middle] > target) {
            return binarySearch(nums, target, start, middle - 1);
        } else {
            return middle;
        }
    }

    private int leftBoundarySearch(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        if (middle == start) {
            if (nums[middle] > nums[end]) {
                return middle;
            } else {
                return end;
            }
        }
        if (nums[middle] >= nums[end]) {
            return leftBoundarySearch(nums, middle, end);
        } else {
            return leftBoundarySearch(nums, start, middle);
        }
    }
}
