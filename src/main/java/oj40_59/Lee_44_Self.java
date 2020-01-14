package oj40_59;

/**
 * 44 通配符匹配
 * state： p 前j个字符是否能匹配s的前i个字符
 * function： if(s[i] == p[j] || p[j] == '?')//这两种情况肯定都匹配，则看前一个字符是否匹配即可
 *                  f[i+1][j+1]=f[i][j]
 *            if(p[j] == '*')// 出现* 则要判断从0 到i+1 是否有一个true，有则为true，否则false
 *                  f[i+1][j+1] = f[i+1][j+1] || f[0...i+1][j]
 * initialValue f[0][0]= true f[s.length + 1][p.length + 1] f[0...s.length][0]= false,
 *              if(p[j] == '*') //从第一个开始连续出现* 则都为true，出现一个非*后，该位置到最后都是false；
 *                                                  f[0][j+1] = f[0][j];
 * out f[s.length][p.lengyh]
 */
public class Lee_44_Self {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < s.length(); i++){
            match[i + 1][0] = false;
        }
        //从第一个开始连续出现* 则都为true，出现一个非*后，该位置到最后都是false；
        for (int i = 0; i < p.length(); i++){
             if (p.charAt(i) == '*'){
                 match[0][i + 1] = match[0][i];
             }else {
                 match[0][i + 1] = false;
             }
        }

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    match[i + 1][j + 1] = match[i][j];
                }
                if (p.charAt(j) == '*'){
                    for (int k = 0; k <= i + 1; k++){
                        match[i + 1][j + 1] = match[i + 1][j + 1] || match[k][j];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "";
        Lee_44_Self self = new Lee_44_Self();
        System.out.println(self.isMatch(s, p));
    }
}
