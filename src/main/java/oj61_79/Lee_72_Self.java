package oj61_79;

/**
 * 编辑距离，将一个字符串替换成另一个字符串，所需要的编辑次数
 */
public class Lee_72_Self {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < len1 + 1; i++){
            distance[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++){
            distance[0][i] = i;
        }

        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    distance[i + 1][j + 1] = distance[i][j];
                }else {
                    int min = Math.min(distance[i][j], distance[i + 1][j]);
                    distance[i + 1][j + 1] = Math.min(min, distance[i][j + 1]) + 1;
                }
            }
        }
        return distance[len1][len2];
    }
}
