package oj120_139;



public class Lint_125_Self {
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] maxValue = new int[A.length + 1][m + 1];
        for (int j = 0; j < m+1; j++){
            maxValue[0][j] = 0;
        }
        for (int i = 1; i < A.length + 1; i++){
            maxValue[i][0] = 0;
        }
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < m + 1; j++){
                int max = maxValue[i][j];
                if (j >= A[i]){
                    max = Math.max(max, maxValue[i][j - A[i]] + V[i]);
                }
                maxValue[i + 1][j] = max;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m + 1; j++){
            if (maxValue[A.length][j] > max){
                max = maxValue[A.length][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 8};
        int[] V = {2, 5, 8};
        int m = 10;
        System.out.println(new Lint_125_Self().backPackII(m, A, V));
    }
}
