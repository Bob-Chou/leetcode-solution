class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int mid = singleQuickSort(nums, left, left, right);
        while (nums.length - k != mid) {
            if (nums.length - k > mid) {
                left = mid + 1;
                mid = (left + right) / 2;
                mid = singleQuickSort(nums, mid, left, right);
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
                mid = singleQuickSort(nums, mid, left, right);
            }
        }
        return nums[mid];
    }

    static private int singleQuickSort(int[] nums, int mid, int left, int right) {
        int tmp;
        int pivot = nums[mid];
        nums[mid] = nums[left];
        nums[left] = pivot;
        while (left < right) {
            while (left < right && nums[right] > pivot) --right;
            if (left == right) return left;
            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            ++left;
            while (left < right && nums[left] < pivot) ++left;
            if (left == right) return left;
            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            --right;
        }
        return left;
    }
}
