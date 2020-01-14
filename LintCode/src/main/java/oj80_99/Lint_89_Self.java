package oj80_99;

public class Lint_89_Self {
    public int kSum(int[] A, int k, int target) {
        // write your code here
        int[][][] f = new int[A.length + 1][k + 1][target + 1];
        for (int i = 0; i < A.length + 1; i++){
            f[i][0][0] = 1;
        }
        // j 和k 由于二者的实际意义与function中的重合所以没有+1而 i在数组中的位置与
        //function中的位置不相同所以+1
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < k + 1; j++){
                for (int t = 0; t < target + 1; t++){
                    f[i + 1][j][t] = f[i][j][t];
                    if (t >= A[i] && j >= 1){
                        f[i + 1][j][t] += f[i][j - 1][t - A[i]];
                    }
                }
            }
        }
        return f[A.length][k][target];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        System.out.println(new Lint_89_Self().kSum(A, k, target));
    }
}
