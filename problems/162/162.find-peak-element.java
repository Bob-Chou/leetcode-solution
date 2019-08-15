class Solution {
    public int findPeakElement(int[] nums) {
        return subfindPeakElement(nums, 0, nums.length-1);
    }

    private int subfindPeakElement(int[] nums, int start, int end) {
        if (start >= end)
            return start;
        int mid = (start + end) / 2;
        if (compareLeft(nums, mid) && compareRight(nums, mid))
            return mid;
        else if (compareLeft(nums, mid))
            return subfindPeakElement(nums, mid + 1, end);
        else
            return subfindPeakElement(nums, start, mid - 1);
    }

    private boolean compareLeft(int[] nums, int i) {
        return i == 0 || nums[i] > nums[i-1];
    }

    private boolean compareRight(int[] nums, int i) {
        return i == nums.length - 1 || nums[i] > nums[i+1];
    }
}
