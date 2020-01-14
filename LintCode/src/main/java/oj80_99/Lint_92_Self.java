package oj80_99;

/**
 * 背包问题1
 * 关键在于， f[i - 1][j - A[j]] 此时我们要判断j >=A[j],如果不大于就不计算该部分
 */
public class Lint_92_Self {
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[][] mValue = new boolean[A.length + 1][m + 1];
        mValue[0][0] = true;
        for (int i = 1; i < A.length + 1; i++){
            mValue[i][0] = true;
        }
        for (int i = 1; i < m + 1; i++){
            mValue[0][i] = false;
        }

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < m + 1; j++){
                mValue[i + 1][j] = mValue[i][j];
                if (j >= A[i] && mValue[i][j - A[i]]){
                    mValue[i + 1][j] = true ;
                }
            }
        }
        for (int j = m; j >= 0; j--){
            if (mValue[A.length][j]){
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int m = 10;
        int[] A = {3,4,8,5};
        Lint_92_Self self = new Lint_92_Self();
        System.out.println(self.backPack(m, A));
    }
}
