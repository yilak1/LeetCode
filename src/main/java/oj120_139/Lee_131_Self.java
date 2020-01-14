package oj120_139;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割字符串，每一个子串都是会回文串，求所有可能的方案
 * 重点：1 分治
 *      2 动态规划
 *      3 DFS
 */
public class Lee_131_Self {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> results = new ArrayList<List<String>>();
        ArrayList<String> list = new ArrayList<>();
        patitionHelper(results, list, 0, s);
        return results;
    }

    public boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void patitionHelper(ArrayList<List<String>> result,
                                ArrayList<String> list,
                                int pos,
                                String s){
        if (pos == s.length()){
            result.add(new ArrayList<>(list));
        }

        StringBuilder str = new StringBuilder();
        for (int i = pos; i < s.length(); i++){
            str.append(s.charAt(i));
            if (isPalindrome(str.toString())){
                list.add(str.toString());
                patitionHelper(result, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
}
