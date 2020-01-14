package Tree;

/**
 * 构建前缀树，并实现插入，查找单词和查找前缀的功能
 * 前缀树节点结构
 *  TireNode{
 *      TireNode[] links;
 *      int R        R代表links数组的长度
 *      boolean isEnd 是否是叶子节点。
 *  }
 */
public class Trie {

    private TrieNode root;

    private class TrieNode{
        TrieNode[] links;
        final int R = 26;
        boolean isEnd;
        public TrieNode(){
            links = new TrieNode[R];
        }

        public boolean containKey(char ch){
            return links[ch - 'a'] != null;
        }
        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }
        public TrieNode get(char ch){
            return links[ch - 'a'];
        }
        public void setEnd(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode tail = root;
        for (int i = 0; i < word.length(); i++){
            if (!tail.containKey(word.charAt(i))){
                tail.put(word.charAt(i), new TrieNode());
            }
            tail = tail.get(word.charAt(i));
        }
        tail.setEnd();
    }
    public TrieNode searchPrefix(String word){
        TrieNode tail = root;
        for (int i = 0; i < word.length(); i++){
            if (tail.containKey(word.charAt(i))){
                tail = tail.get(word.charAt(i));
            }else {
                return null;
            }
        }
        return tail;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    public boolean searchWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

}
