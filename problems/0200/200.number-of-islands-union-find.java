class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind helper = new UnionFind(rows, cols);

        int waterUnit = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') {
                    ++waterUnit;
                    continue;
                }
                int id = i * cols + j;
                if (i > 0 && grid[i-1][j] == '1')
                    helper.unite(id, id - cols);
                if (j > 0 && grid[i][j-1] == '1')
                    helper.unite(id, id - 1);
            }
        }
        return helper.roots.size() - waterUnit;
    }
}

class UnionFind {
    private int rows;
    private int cols;
    private int[] ids;
    private int[] nums;
    public Set<Integer> roots;
    public UnionFind(int r, int c) {
        rows = r;
        cols = c;
        ids = new int[r * c];
        nums = new int[r * c];
        roots = new HashSet<>();
        for (int i = 0; i < r * c; ++i) {
            ids[i] = i;
            nums[i] = 1;
            roots.add(i);
        }
    }
    public int find(int id) {
        while (ids[id] != id) {
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return ids[id];
    }
    public void unite(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);

        if (root1 == root2)
            return;

        if (nums[root1] < nums[root2]) {
            nums[root2] += nums[root1];
            ids[root1] = ids[root2];
            roots.remove(root1);
        } else {
            nums[root1] += nums[root2];
            ids[root2] = ids[root1];
            roots.remove(root2);
        }
    }
}
