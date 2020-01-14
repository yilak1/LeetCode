package oj60_79;

/**
 * 最长公共子串
 */
public class Lint_79_Self {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        int[][] lcs = new int[lenA + 1][lenB + 1];
        for (int i = 0; i < lenA; i++){
            for (int j = 0; j < lenB; j++){
                if (A.charAt(i) == B.charAt(j)){
                   lcs[i + 1][j + 1] = lcs[i][j] + 1;
                }else {
                    lcs[i + 1][j + 1] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < lenA + 1; i++){
            for (int j = 0; j < lenB + 1; j++){
                if (lcs[i][j] > max){
                    max = lcs[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String A = "abc";
        String B = "a";
        Lint_79_Self self = new Lint_79_Self();
        System.out.println(self.longestCommonSubstring(A, B));
    }
}
