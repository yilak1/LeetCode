package oj61_79;

public class Lee_64_Self {
    public int minPathSum(int[][] grid) {
        int row = grid[0].length;
        int high = grid.length;
        int[][] f = new int[high][row];
        f[0][0] = grid[0][0];
        for (int i = 1; i < row; i++){
            f[0][i] = grid[0][i] + f[0][i - 1];
        }
        for (int i = 1; i < high; i++){
            f[i][0] = grid[i][0] + f[i - 1][0];
        }

        for (int i = 1; i < high; i++){
            for (int j = 1; j < row; j++){
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[high - 1][row - 1];
    }

    public static void main(String[] args) {
        int[][] grad = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};
        Lee_64_Self self = new Lee_64_Self();
        System.out.println(self.minPathSum(grad));
    }
}
