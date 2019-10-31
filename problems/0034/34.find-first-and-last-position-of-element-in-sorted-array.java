class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        // search pivot target
        int start = 0;
        int end = nums.length - 1;
        int pivot = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                pivot = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (pivot != -1) {
            // search left to find the boundary
            start = 0;
            end = pivot - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            ans[0] = end + 1;

            // search right to find the boundary
            start = pivot + 1;
            end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            ans[1] = start - 1;
        }

        return ans;
    }
}
