# Problem 1102
## Review log
+ 10/31/2019 Using Dijkstra

## Insight
Could compare to shortest path problem. Using Dijsktra to solve! Remember, Java cannot support `decreaseKey`, we can just add a new data each time we update our path, and this won't affect our result. Also remember, we when adding a vertex into `PriorityQueue`, we couldn't use reference denoting distance, we need to assign a int to it to avoid errors.

A more clever way is to use binary search! Just use DFS to find if there is a valid path given an upper bound of answer. Keeping shrinking the bound to find final answer.
```java
class Solution {
    private boolean isValid(int[][] A, int limit, boolean[][] marked, int[] dirs, int i, int j, int m, int n) {
        marked[i][j] = true;
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        for (int k=0; k<4; k++) {
            int ni = i + dirs[k];
            int nj = j + dirs[k + 1];
            if (ni >= 0 && nj >= 0 && ni < m && nj < n && !marked[ni][nj] && A[ni][nj] >= limit) {
                if (isValid(A, limit, marked, dirs, ni, nj, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumMinimumPath(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int lo = 1;
        int hi = Math.min(A[0][0], A[R - 1][C - 1]) + 1;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            boolean[][] visited = new boolean[R][C];
            if (isValid(A, mid, visited, dirs, 0, 0, R, C)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }
}

```
