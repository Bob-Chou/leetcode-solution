class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] != nums[i-1]) {
                genSubset(nums, i, new ArrayList<>(), ans);
            }
        }
        return ans;
    }

    private void genSubset(int[] nums, int start, List<Integer> subset, List<List<Integer>> ans) {
        if (start >= nums.length) {
            return;
        }

        subset.add(nums[start]);
        ans.add(new ArrayList<>(subset));
        for (int i = start + 1; i < nums.length; ++i) {
            if (i == start + 1 || nums[i] != nums[i-1]) {
                genSubset(nums, i, subset, ans);
            }
        }
        subset.remove(subset.size()-1);

    }
}
