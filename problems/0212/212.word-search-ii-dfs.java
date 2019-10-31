class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length < 1 || board[0].length < 1 || words.length < 1)
            return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            boolean breakFlag = false;
            for (int i = 0; i < board.length && !breakFlag; ++i) {
                for (int j = 0; j < board[0].length && !breakFlag; ++j) {
                    if (dfs(board, word, i, j, 0)) {
                        ans.add(word);
                        breakFlag = true;
                    }
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int p) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        char c = board[i][j];
        if (c != word.charAt(p))
            return false;
        else if (p == word.length() - 1)
            return true;

        board[i][j] = '#';
        boolean ans = false;
        if (!ans)
            ans |= dfs(board, word, i+1, j, p+1);
        if (!ans)
            ans |= dfs(board, word, i-1, j, p+1);
        if (!ans)
            ans |= dfs(board, word, i, j+1, p+1);
        if (!ans)
            ans |= dfs(board, word, i, j-1, p+1);
        board[i][j] = c;
        return ans;
    }
}
