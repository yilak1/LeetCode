package oj1_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码组合，
 * 递归题
 */
public class Lee_17_Self {

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        Map<Character, String> digitsMap = new HashMap<Character, String>();
        digitsMap.put('2', "abc");
        digitsMap.put('3', "def");
        digitsMap.put('4', "ghi");
        digitsMap.put('5', "jkl");
        digitsMap.put('6', "mno");
        digitsMap.put('7', "pqrs");
        digitsMap.put('8', "tuv");
        digitsMap.put('9', "wxyz");
        StringBuilder stringBuilder = new StringBuilder();
        letterBackTrack(results, digitsMap, digits, 0, stringBuilder);
        return results;
    }

    public void letterBackTrack(List<String> results,
                                Map<Character, String> digitsMap,
                                String digits,
                                int pos,
                                StringBuilder strBuilder){
        if (digits.length() == 0){
            return;
        }
        if (pos == digits.length()){
            results.add(new String(strBuilder.toString()));
            return;
        }
        String letter = digitsMap.get(digits.charAt(pos));
        for (int i = 0; i < letter.length(); i++){
            strBuilder.append(letter.charAt(i));
            letterBackTrack(results, digitsMap, digits, pos + 1, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Lee_17_Self self = new Lee_17_Self();
        String digits = "";
        System.out.println(self.letterCombinations(digits));
    }
}
