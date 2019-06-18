class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            // skip duplicate
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            // if too large, early stop
            if (nums[i] * 4 > target)
                break;
            for (int j = i + 1; j < nums.length; ++j) {
                // skip duplicate
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                // if too large, early stop
                if (nums[j] * 3 > target - nums[i])
                    break;
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    // if too large, early stop
                    if (nums[l] * 2 > target - nums[i] - nums[j])
                        break;
                    // if too small, early stop
                    if (nums[r] * 2 < target - nums[i] - nums[j])
                        break;
                    if (nums[r] + nums[l] + nums[i] + nums[j] == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // skip duplicate
                        while (++l < r && nums[l] == nums[l-1]);
                        while (l < --r && nums[r] == nums[r+1]);
                    } else if (nums[r] + nums[l] + nums[i] + nums[j] < target) {
                        ++l;
                    } else {
                        --r;
                    }
                }
            }
        }
        return ans;
    }
}
