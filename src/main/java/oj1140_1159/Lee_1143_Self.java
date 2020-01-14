package oj1140_1159;

import java.util.Arrays;

/**
 * 最长公共子序列 ，不连续
 */
public class Lee_1143_Self {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                if (text1.charAt(i) == text2.charAt(j)){
                    f[i + 1][j + 1] = f[i][j] + 1;
                }else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }

        return f[len1][len2];
    }

    public static void main(String[] args) {
        Lee_1143_Self self = new Lee_1143_Self();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(self.longestCommonSubsequence(text1, text2));
    }
}
