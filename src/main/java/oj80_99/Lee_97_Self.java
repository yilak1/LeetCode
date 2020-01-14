package oj80_99;

/**
 * 动态规划题
 * 重点注意initialValue 和 比较的时候
 */
public class Lee_97_Self {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] isInter = new boolean[s1.length() + 1][s2.length() + 1];
        //三个字符串都为空 false
        if (s1 == null || s2 == null || s3==null){
            return false;
        }
        //长度和不等于第三个串的长度false
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        isInter[0][0] = true;
        //初始化，截取字串相等返回true，其他false
        for (int i = 0; i < s1.length(); i++){
                isInter[i + 1][0] = s1.substring(0, i + 1).equals(s3.substring(0, i + 1));

        }
        for (int i = 0; i < s2.length(); i++){
                isInter[0][i + 1] = s2.substring(0, i + 1).equals(s3.substring(0, i + 1));
        }

        for (int i = 0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                isInter[i + 1][j + 1] = false;
//                if (i + j + 2 >= s3.length()){
//                    break;
//                }
                //如果连个串的最后一个字符都和s3相等的话就会出问题，所以要加个或语句
                if (s1.charAt(i) == s3.charAt(i + j + 1)){
                    isInter[i + 1][j + 1] = isInter[i + 1][j + 1]||isInter[i][j + 1];
                }
                if (s2.charAt(j) == s3.charAt(i + j + 1)){
                    isInter[i + 1][j + 1] = isInter[i + 1][j + 1]||isInter[i + 1][j];
                }
            }
        }
        return isInter[s1.length()][s2.length()];
    }
}
