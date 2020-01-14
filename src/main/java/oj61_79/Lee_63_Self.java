package oj61_79;

/**
 * 不同的路径数，在其基础上添加障碍，不允许走。
 * 动态规划题
 * 把障碍的位置设置成0，即为不能通过
 */
public class Lee_63_Self {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] != 0) {
                f[0][i] = 0;
                while (i < n){
                    f[0][i++] = 0;
                }
            }else {
                f[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++){
            if(obstacleGrid[i][0] != 0) {
                while (i < m){
                    f[i++][0] = 0;
                }
            }else {
                f[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] != 0) {
                    f[i][j] = 0;
                }else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacles = {{1, 0}};
        Lee_63_Self self = new Lee_63_Self();
        System.out.println(self.uniquePathsWithObstacles(obstacles));
    }
}
