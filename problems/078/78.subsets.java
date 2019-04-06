class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        genSubset(nums, 1, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void genSubset(int[] nums, int depth, int start, List<Integer> cache, List<List<Integer>> ans) {
        if (start == 0) {
            ans.add(new ArrayList<>(cache));
        }
        if (depth > nums.length || start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            cache.add(nums[i]);
            ans.add(new ArrayList<>(cache));
            genSubset(nums, depth + 1, i+1, cache, ans);
            cache.remove(cache.size() - 1);
        }
        return;
    }
}
