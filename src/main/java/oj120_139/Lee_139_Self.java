package oj120_139;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词拆分
 * 字符串是否可以拆分成多个字典里的单词
 * state 前i个字符串是否可以被字典拆分
 * function 找出第i个位置前字典序字符串最大的单词数的位置，如果f[j] ==true 并且 [j+1, j] 闭区间字符串在字典中。返回true
 * initial f[0] = true, f[s.length + 1]
 * out f[s.length]
 */
public class Lee_139_Self {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        int max = Integer.MIN_VALUE;
        //找出最大单词数
        for (int i = 0; i < wordDict.size(); i++){
            if (wordDict.get(i).length() > max){
                max = wordDict.get(i).length();
            }
        }
        f[0] = true;
        for (int i = 0; i < s.length(); i++){
            for (int j = i - max < -1? -1:(i - max); j < i; j++) {
                if (f[j + 1] && wordDict.contains(s.substring(j + 1, i + 1))){
                    f[i+1] = true;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("Leet");
        wordDict.add("code");
        Lee_139_Self self = new Lee_139_Self();
        System.out.println(self.wordBreak("Leetcode", wordDict));
    }
}
