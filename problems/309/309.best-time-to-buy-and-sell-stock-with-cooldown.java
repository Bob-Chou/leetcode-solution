class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        if (prices.length == 2) return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        int maxProfit = 0;
        int[] sold = new int[prices.length], held = new int[prices.length];
        sold[0] = 0;
        sold[1] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        held[0] = -prices[0];
        held[1] = prices[1] > prices[0] ? -prices[0] : -prices[1];
        for (int i = 2; i < prices.length; ++i) {
            sold[i] = sold[i-1] > held[i-1] + prices[i] ? sold[i-1] : held[i-1] + prices[i];
            held[i] = held[i-1] > sold[i-2] - prices[i] ? held[i-1] : sold[i-2] - prices[i];
            maxProfit = sold[i] > maxProfit ? sold[i] : maxProfit;
        }
        return maxProfit;
    }
}
