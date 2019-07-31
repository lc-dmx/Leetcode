class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > min) {
                max = Math.max(max, price - min);
            } else {
                min = price;
            }
        }

        return max;
    }
}
