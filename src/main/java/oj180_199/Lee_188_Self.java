package oj180_199;

/**
 * 股票问题，动态规划
 * state: f[i][k][0 or 1] 第i天进行k次交易，当前持有或者未持有股票时获得的最大利润
 * function: f[i][k][0] = max(f[i - 1][k][0](前一天未持有股票)，
 *                        f[i - 1][k][1] + prices[i](前一天持有股票,出售股票))
 *           f[i][k][1] = max(f[i - 1][k][1](前一天持有股票),
 *                        f[i - 1][k - 1][0] - prices[i](前一天未持有股票，买入股票))
 * start:f[-1][0][0] = 0
 *       f[-1][k][0] = 0
 *       f[-1][k][1] = -Min
 *       f[i][0][1] = -Min
 * end:f[n-1][k][0] 最后一天，最大交易，且未持有股票的最大收益。
 * 使用%2压缩空间
 */
public class Lee_188_Self {
    /*public int maxProfit(int k, int[] prices) {
        int day = prices.length;
        //int[][][] f = new int[day + 1][k + 1][2];
        int[][][] f = new int[3][3][2];
        //初始化
        for (int i = 0; i <= k; i++){
            f[0][i%3][0] = 0;
            f[0][i%3][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= day; i++){
            f[i%3][0][1] = Integer.MIN_VALUE;
        }

        //状态转移方程
        for (int i = 1; i <= day; i++){
            for (int j = 1; j <= k; j++){
                f[i%3][j%3][0] = Math.max(f[(i - 1)%3][j%3][0], f[(i - 1)%3][j%3][1] + prices[i - 1]);
                f[i%3][j%3][1] = Math.max(f[(i - 1)%3][j%3][1], f[(i - 1)%3][(j - 1)%3][0] - prices[i - 1]);
            }
        }
        return f[day%3][k%3][0];
    }*/
    public int maxProfit(int k, int[] prices) {

        int day = prices.length;
        if (k > day/2){
            return maxProfitAny(prices);
        }
        int[][][] f = new int[day + 1][k + 1][2];
        //int[][][] f = new int[2][2][2];
        //初始化

        for (int i = 0; i <= k; i++){
            f[0][i][0] = 0;
            f[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= day; i++){
            f[i][0][1] = Integer.MIN_VALUE;
        }

        //状态转移方程
        for (int i = 1; i <= day; i++){
            for (int j = 1; j <= k; j++){
                f[i][j][0] = Math.max(f[(i - 1)][j][0], f[(i - 1)][j][1] + prices[i - 1]);
                f[i][j][1] = Math.max(f[(i - 1)][j][1], f[(i - 1)][(j - 1)][0] - prices[i - 1]);
            }
        }
        return f[day][k][0];
    }

    public int maxProfitAny(int[] prices) {
        int fi0 = 0;
        int fi1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            int temp = fi0;
            fi0 = Math.max(fi0, fi1 + prices[i]);
            fi1 = Math.max(fi1, temp - prices[i]);
        }
        return fi0;
    }

    public static void main(String[] args) {
        Lee_188_Self self = new Lee_188_Self();
        int k = 2;
        int[] prices = {3,3, 5, 0, 0, 3, 1, 4};
        System.out.println(self.maxProfit(k, prices));
    }
}
