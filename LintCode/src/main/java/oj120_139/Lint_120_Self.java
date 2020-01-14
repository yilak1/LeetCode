package oj120_139;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lint_120_Self {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict.size() == 0 || dict == null){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        dict.remove(start);
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
                            if (temp.equals(end)){
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
}
