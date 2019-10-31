class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0].length < 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] methods = new int[m+1][n+1];

        methods[0][1] = 1;

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (obstacleGrid[i-1][j-1] != 1)
                    methods[i][j] = methods[i-1][j] + methods[i][j-1];
            }
        }

        return methods[m][n];
    }
}
