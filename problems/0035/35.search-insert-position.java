class Solution {
    public int searchInsert(int[] nums, int target) {
        int ret = Arrays.binarySearch(nums, target);
        if (ret < 0) ret = - ret - 1;
        return ret;
    }
}
