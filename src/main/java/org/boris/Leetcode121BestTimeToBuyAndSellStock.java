package org.boris;

public class Leetcode121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int left = prices[0];
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < left) {
                left = prices[i];
            } else {
                result = Math.max(result, prices[i] - left);
            }
        }

        return result;
    }
}
