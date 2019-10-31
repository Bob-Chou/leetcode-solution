class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinationSum(int[] candidates, int target, int start, List<Integer> cache, List<List<Integer>> ans) {
        for (int i = start; i < candidates.length; ++i) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            cache.add(candidates[i]);
            if (target == candidates[i]) {
                ans.add(new ArrayList<>(cache));
                cache.remove(cache.size() - 1);
                break;
            }
            findCombinationSum(candidates, target - candidates[i], i + 1, cache, ans);
            cache.remove(cache.size() - 1);
        }
    }
}
