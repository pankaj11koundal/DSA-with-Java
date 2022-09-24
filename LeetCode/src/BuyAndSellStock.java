public class BuyAndSellStock {
    static class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0], profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (min > prices[i]) {
                    min = prices[i];
                }

                profit = Math.max(profit, prices[i] - min);
            }

            return profit;
        }
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}
