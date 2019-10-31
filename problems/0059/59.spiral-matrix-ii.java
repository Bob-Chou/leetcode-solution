class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int cnt = 1;
        for (int inner = 0; inner < (n + 1) / 2; ++inner) {
            // upper line
            for (int i = inner; i < n - inner; ++i) {
                matrix[inner][i] = cnt++;
            }

            // right line
            for (int i = inner + 1; i < n - inner - 1; ++i) {
                matrix[i][n - inner - 1] = cnt++;
            }

            // bottom line
            if (inner < n - inner - 1)
            {
                for (int i = n - inner - 1; i >= inner; --i) {
                    matrix[n - inner - 1][i] = cnt++;
                }
            }

            // left line
            if (inner < n - inner - 1) {
                for (int i = n - inner - 2; i > inner; --i) {
                    matrix[i][inner] = cnt++;
                }
            }
        }

        return matrix;
    }
}
