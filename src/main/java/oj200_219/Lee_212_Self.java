package oj200_219;

import java.util.ArrayList;
import java.util.List;

public class Lee_212_Self {
    //定义Trie树
    private class TrieNode{
        TrieNode[] links;
        final int R = 26;
        boolean isEnd;
        TrieNode(){
            links = new TrieNode[R];
        }
        boolean containKey(char ch){
            return links[ch - 'a'] != null;
        }
        void put(char ch){
            links[ch - 'a'] = new TrieNode();
        }
        TrieNode get(char ch){
            return links[ch - 'a'];
        }
        void setEnd(){
            isEnd = true;
        }
        boolean isEnd(){
            return isEnd;
        }
    }
    //dfs查找
    //定义四个方向的搜索路径
    private int[] xDir = {1, 0, 0, -1};
    private int[] yDir = {0, 1, -1, 0};
    private void findWordsHelper(List<String> results,
                                  char[][] board,
                                  StringBuilder word,
                                  int x,
                                  int y,
                                  TrieNode root){

        //出口
        if (root == null){
            return;
        }
        if (root != null && root.isEnd &&
                !results.contains(word.toString())){
            results.add(word.toString());
        }
        char temp = board[x][y];
        //防止回路
        board[x][y] = 0;
        for (int i = 0; i < xDir.length; i++){
                int newX = x + xDir[i];
                int newY = y + yDir[i];
                if (isValid(newX, newY, board)){
                    word.append(board[newX][newY]);
                    findWordsHelper(results, board, word,
                            newX, newY, root.links[board[newX][newY] - 'a']);
                    word.deleteCharAt(word.length() - 1);
                }
        }
        board[x][y] = temp;

    }
    private boolean isValid(int x, int y, char[][] board){
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length
                && board[x][y] != 0){
            return true;
        }
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        if (board.length == 0){
            return results;
        }
        if (board[0].length == 0){
            return results;
        }
        //根据word构建Trie树
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++){
            TrieNode tail = root;
            for (int j = 0; j < words[i].length(); j++){
                char ch = words[i].charAt(j);
                if (!tail.containKey(ch)){
                    tail.put(words[i].charAt(j));
                }
                tail = tail.get(words[i].charAt(j));
            }
            tail.setEnd();
        }

        //使用dfs
        for (int i = 0; i < board.length; i++){
            for (int j = 0 ; j < board[0].length; j++){
                word.append(board[i][j]);
                findWordsHelper(results, board,word,i, j,root.links[board[i][j] - 'a']);
                word.deleteCharAt(word.length() - 1);
            }
        }
        return results;
    }

    public static void main(String[] args) {
//        char[][] board = {{'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'a', 'b'}};
        String[] words = {"ba"};
        Lee_212_Self self = new Lee_212_Self();
        System.out.println(self.findWords(board, words));
    }
}
