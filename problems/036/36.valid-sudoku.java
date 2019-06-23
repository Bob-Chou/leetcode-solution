class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] encoder = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        int[] rowCode = new int[9];
        int[] colCode = new int[9];
        int[][] boxCode = new int[3][3];

        for (int i = 0; i < 9; ++i) {
            rowCode[i] = 1;
            colCode[i] = 1;
            boxCode[i/3][i%3] = 1;
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {

                int num = board[i][j] - '0';
                if (num < 1 || num > 9)
                    continue;
                int code = encoder[num - 1];

                //check row
                if (rowCode[i] % code != 0)
                    rowCode[i] *= code;
                else
                    return false;

                //check column
                if (colCode[j] % code != 0)
                    colCode[j] *= code;
                else
                    return false;

                // check subbox
                if (boxCode[i/3][j/3] % code != 0)
                    boxCode[i/3][j/3] *= code;
                else
                    return false;
            }
        }

        return true;
    }
}
