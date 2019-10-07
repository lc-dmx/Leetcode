class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len) {
            return maxProfitII(prices);
        }
        //第i天时最多k次交易，并且最后一次交易再最后一天卖出
        int[] local = new int[k + 1];
        //第i天时最多k次交易
        int[] global = new int[k + 1];

        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(local[j] + diff, global[j - 1] + Math.max(diff, 0));
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }

    private int maxProfitII(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
