package oj120_139;

public class Lee_123_Self {
    public int maxProfit(int[] prices) {
        int[][][] f = new int[prices.length + 1][3][2];
        for (int i = 0; i < prices.length + 1; i++){
            for (int k = 0; k < 3; k++){
                //初始化
                if (i == 0){
                    f[i][k][0] = 0;
                    f[i][k][1] = Integer.MIN_VALUE;
                }
                f[i][0][1] = Integer.MIN_VALUE;
                // 状态转移方程
                if ( i > 0 && k > 0){
                    f[i][k][0] = Math.max(f[i - 1][k][0], f[i - 1][k][1] + prices[i - 1]);
                    f[i][k][1] = Math.max(f[i- 1][k][1], f[i - 1][k - 1][0] - prices[i - 1]);
                }
            }
        }
        return f[prices.length][2][0];
    }
}
