class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[][][] helperArray = new int[candidates.length][candidates.length][target+1];
        for (int i=0; i<candidates.length; ++i) {
            for (int t=0; t<=target; t+=candidates[i]) {
                helperArray[i][i][t] = 1;
            }
        }
        for (int i = 0; i < candidates.length; ++i) {
            for (int j = i-1; j >= 0; --j) {
                for (int t = 0; t <= target; ++t) {
                    for (int m=0; t - m * candidates[j] >= 0; ++m) {
                        helperArray[j][i][t] += helperArray[j+1][i][t-m*candidates[j]];
                    }
                    // System.out.println(j + "," + i + "," + t + ": " + helperArray[j][i][t]);
                }
            }
        }
        System.out.println(helperArray[0][candidates.length - 1][target]);
        return new ArrayList<List<Integer>>();
    }
}
