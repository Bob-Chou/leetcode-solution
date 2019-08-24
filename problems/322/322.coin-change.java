class Solution {
    public int coinChange(int[] coins, int amount) {
<<<<<<< HEAD
        
=======
        if (amount == 0) return 0;
        if (coins.length < 1) return -1;
        int[] helper = new int[amount+1];
        helper[0] = 0;
        for (int i = 1; i < amount + 1; ++i) {
            int minNum = Integer.MAX_VALUE;
            for (int j : coins) {
                if (i - j >= 0 && helper[i - j] >=0 && helper[i - j] + 1 < minNum) {
                    minNum = helper[i - j] + 1;
                }
            }
            if (minNum < Integer.MAX_VALUE) {
                helper[i] = minNum;
            } else {
                helper[i] = -1;
            }
        }
        return helper[amount];
>>>>>>> master
    }
}
