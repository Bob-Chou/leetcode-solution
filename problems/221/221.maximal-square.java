class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1) return 0;
        int[][] helper = new int[matrix.length+1][matrix[0].length+1];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    int minPrev = helper[i][j];
                    if (helper[i][j+1] < minPrev) minPrev = helper[i][j+1];
                    if (helper[i+1][j] < minPrev) minPrev = helper[i+1][j];
                    if (minPrev + 1 > maxArea) maxArea = minPrev + 1;
                    helper[i+1][j+1] = minPrev + 1;
                }
            }
        }
        return maxArea * maxArea;
    }
}
