package oj100_119;

import javafx.util.Pair;

import java.util.*;

/**
 * word ladder1
 */
public class Lee_127_Self {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || wordList == null){
            return 0;
        }
        Set<String> dict = new HashSet<>();
        for (String word : wordList){
            dict.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);
        int length = 1;
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++){
                String begin = queue.poll();
                for (char j = 'a'; j <= 'z'; j++){
                    for (int k = 0; k < begin.length(); k++){
                        String temp = replace(begin, k, j);
                        if (begin.charAt(k) == j){
                            continue;
                        }
                        if (dict.contains(temp)){
                            if (temp.equals(endWord)){
                                return length + 1;
                            }
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    public String replace(String begin, int k, char j){
        char[] chars = begin.toCharArray();
        chars[k] = j;
        return new String(chars);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog",
                "lot", "log"});
        Lee_127_Self self = new Lee_127_Self();
        System.out.println(self.ladderLength(beginWord, endWord, wordList));
    }
}
