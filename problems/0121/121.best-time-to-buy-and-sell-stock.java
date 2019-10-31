class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        // helper[i] means the max profit we sell the stone at day i
        int[] helper = new int[prices.length];
        int ans = 0;
        helper[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            /** To sell the stone at day i, we have two choices:
            *   1. buy before day i-1. The maximum profit should be helper[i-1] + prices[i] - prices[i-1]
            *   2. buy at day i-1. The profit should be prices[i] - prices[i-1]
            */
            helper[i] = prices[i]-prices[i-1];
            if (helper[i-1] > 0) {
                helper[i] += helper[i-1];
            }
            if (helper[i] > ans) ans = helper[i];
        }
        return ans;
    }
}
