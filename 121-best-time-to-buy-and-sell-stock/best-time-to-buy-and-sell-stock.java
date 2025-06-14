class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0; 
        int buy = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i]; 
            } else {
                int sell = prices[i] - buy; 
                profit = Math.max(sell, profit);
            }
        }
        return profit;
    }
}
