package oj100_119;

/**
 *
 */
public class Lee_115_Self {
    public int numDistinct(String s, String t) {
        int[][] disCount = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < t.length() + 1; i++){
            disCount[0][i] = 0;
        }
        for (int i = 0; i < s.length() + 1; i++){
            disCount[i][0] = 1;
        }

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < t.length(); j++){
                if (s.charAt(i) == t.charAt(j)){
                    disCount[i + 1][j + 1] = disCount[i][j] + disCount[i][j + 1];
                }else {
                    disCount[i + 1][j + 1] = disCount[i][j + 1];
                }
            }
        }
        return disCount[s.length()][t.length()];
    }
}
