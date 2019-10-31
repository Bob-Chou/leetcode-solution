class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] helper = new int[dungeon.length][dungeon[0].length];
        int minHealth = 1;

        for (int i = dungeon.length - 1; i >= 0; --i) {
            for (int j = dungeon[0].length - 1; j >= 0; --j) {
                helper[i][j] = -dungeon[i][j];
                if (i < dungeon.length - 1 && j < dungeon[0].length -1) {
                    helper[i][j] += Math.min(helper[i+1][j], helper[i][j+1]) ;
                } else if (i < dungeon.length - 1) {
                    helper[i][j] += helper[i+1][j];
                } else if (j < dungeon[0].length - 1) {
                    helper[i][j] += helper[i][j+1];
                } else {
                    helper[i][j] += 1;
                }
                helper[i][j] = Math.max(helper[i][j], 1);
            }
        }

        return helper[0][0];
    }
}
