package oj120_139;

/**
 * 股票1，
 * f[i][1][0] = Math.max(f[i - 1][1][0], f[i - 1][1][1] + prices[i])
 * f[i][1][1] = Math.max(f[i - 1][1][1], f[i - 1][0][0] - prices[i])
 * 缩减中间列即可且f[i - 1][0][0] = 0
 */
public class Lee_121_Self {
    public int maxProfit(int[] prices) {
        int fi0 = 0;
        int fi1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            fi0 = Math.max(fi0, fi1 + prices[i]);
            fi1 = Math.max(fi1, - prices[i]);

        }
        return fi0;
    }
}
