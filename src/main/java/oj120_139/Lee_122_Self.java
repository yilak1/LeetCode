package oj120_139;

import java.util.Arrays;

public class Lee_122_Self {
    public int maxProfit(int[] prices) {
        int fi0 = 0;
        int fi1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            int temp = fi0;
            fi0 = Math.max(fi0, fi1 + prices[i]);
            fi1 = Math.max(fi1, temp - prices[i]);
        }
        return fi0;
    }
}
