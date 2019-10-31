class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0 || k == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        boolean[] mask = new boolean[n];
        List<Integer> subCombList = new ArrayList<>();
        for (int i = 0; i < mask.length; ++i) {
            subCombine(ans, subCombList, i+1, k, mask);
        }
        return ans;
    }

    private void subCombine(List<List<Integer>> ans, List<Integer> subCombList, int num, int k, boolean[] mask) {
        subCombList.add(num);
        mask[num-1] = true;
        if (k == 1) {
            ans.add(new ArrayList<>(subCombList));
        } else {
            for (int i = num; i < mask.length; ++i) {
                if (!mask[i])
                    subCombine(ans, subCombList, i+1, k-1, mask);
            }
        }
        mask[num-1] = false;
        subCombList.remove(subCombList.size()-1);
    }
}
