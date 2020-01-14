package oj61_79;

/**
 * 动态规划题
 * 矩阵计数
 * state 到达(i, j)的不同路径数量
 * function  （i - 1, j） + (i, j - 1)
 * initialValue 横竖都为1
 * out
 */
public class Lee_62_Self {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < n; i++){
            f[0][i] = 1;
        }
        for (int i = 0; i < m; i++){
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
