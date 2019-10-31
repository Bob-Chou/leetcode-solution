class UnionFind {
    private int[] ids;
    private int[] unionSizes;

    public UnionFind(int size) {
        ids = new int[size];
        unionSizes = new int[size];
        for (int i = 0; i < size; ++i) {
            ids[i] = i;
            unionSizes[i] = 1;
        }
    }

    public void unite(int id1, int id2, boolean[] isFree) {
        int root1 = getRoot(id1);
        int root2 = getRoot(id2);

        if (id1 == id2)
            return;

        if (unionSizes[root1] < unionSizes[root2]) {
            unionSizes[root2] += unionSizes[root1];
            ids[root1] = root2;
        } else {
            unionSizes[root1] += unionSizes[root2];
            ids[root2] = root1;
        }

        isFree[root1] |= isFree[root2];
        isFree[root2] |= isFree[root1];
    }

    public int getRoot(int id) {
        while (ids[id] != id) {
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return id;
    }
}


class Solution {
    private int rows;
    private int cols;

    public void solve(char[][] board) {
        if (board.length < 1 || board[0].length < 1)
            return;

        rows = board.length;
        cols = board[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        boolean[] isFree = new boolean[rows * cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int id = i * cols + j;
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
                        isFree[uf.getRoot(id)] = true;
                    if (i > 0 && board[i-1][j] == 'O')
                        uf.unite(id, id - cols, isFree);
                    if (i < rows - 1 && board[i+1][j] == 'O')
                        uf.unite(id, id + cols, isFree);
                    if (j > 0 && board[i][j-1] == 'O')
                        uf.unite(id, id - 1, isFree);
                    if (j < cols - 1 && board[i][j+1] == 'O')
                        uf.unite(id, id + 1, isFree);
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int id = i * cols + j;
                if (board[i][j] == 'O' && !isFree[uf.getRoot(id)]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
