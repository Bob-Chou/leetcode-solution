class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        circleOrder(matrix, 0, ans);
        return ans;
    }

    private void circleOrder(int[][] matrix, int inner, List<Integer> ans) {
        if (matrix.length < 1)
            return;

        int rows = matrix.length;
        int columns = matrix[0].length;

        if (inner > (rows - 1) / 2 || inner > (columns - 1) / 2)
            return;

        // upper line
        for (int i = inner; i < columns - inner; ++i) {
            ans.add(matrix[inner][i]);
        }

        // right line
        for (int i = inner + 1; i < rows - inner - 1; ++i) {
            ans.add(matrix[i][columns - inner - 1]);
        }

        // bottom line
        if (inner < rows - inner - 1)
        {
            for (int i = columns - inner - 1; i >= inner; --i) {
                ans.add(matrix[rows - inner - 1][i]);
            }
        }

        // left line
        if (inner < columns - inner - 1) {
            for (int i = rows - inner - 2; i > inner; --i) {
                ans.add(matrix[i][inner]);
            }
        }

        circleOrder(matrix, inner + 1, ans);
    }
}
