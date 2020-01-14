package oj300_319;

public class Lee_309_Self {
    public int maxProfit(int[] prices) {
        int fiPre0 = 0;
        int fi0 = 0;
        int fi1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            int temp = fi0;
            fi0 = Math.max(fi0, fi1 + prices[i]);
            fi1 = Math.max(fi1, fiPre0 - prices[i]);
            fiPre0 = temp;
        }
        return fi0;
    }
}
