class Solution {
    public boolean exist(char[][] board, String word) {
        boolean rtn = false;
        for (int i = 0 ; i < board.length && !rtn; ++i) {
            for (int j = 0; j < board[0].length && !rtn; ++j) {
                rtn = retrieve(board, word, i, j, 0);
            }
        }
        return rtn;
    }

    public boolean retrieve(char[][] board, String word, int l, int c, int index) {
        if (index == word.length()) {
            return true;
        }
        if (l < 0 || l >= board.length || c < 0 || c >= board[l].length) {
            return false;
        }
        if (board[l][c] != word.charAt(index)){
            return false;
        }
        if ( board[l][c] == word.charAt(index)) {
            board[l][c] += 60;
            boolean rtn = false;
            rtn = retrieve(board, word, l+1, c, index + 1)
            || retrieve(board, word, l, c+1, index + 1)
            || retrieve(board, word, l-1, c, index + 1)
            || retrieve(board, word, l, c-1, index + 1);
            board[l][c] -= 60;
            return rtn;
        }
        return false;
    }
}
