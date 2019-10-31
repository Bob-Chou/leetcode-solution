class Solution {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        // DP solution
        // helper[n] means total unique structures for n different numbers
        // notice that we add helper[0] to simplify our code
        int[] helper = new int[n+1];
        helper[0] = 1;
        for (int i=1; i < n+1; ++i) {
            // to solve helper[i], we pick j < i as the root, and solve the
            // unique structures of left subtree and right subtree.
            for (int j=1; j < i+1; ++j) {
                // the total structures of left subtree is helper[j-1]
                // the total structures of right subtree is helper[i-j]
                helper[i] += helper[j-1] * helper[i-j];
            }
        }
        return helper[n];
    }
}
