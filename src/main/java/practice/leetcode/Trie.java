package practice.leetcode;

public class Trie {
    /** Initialize your data structure here. */
    private MyTrieNode root = new MyTrieNode();

    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        MyTrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (null == node.childs[ch - 'a']) {
                node.childs[ch - 'a'] = new MyTrieNode();
            }
            if (i == word.length() - 1) {
                System.out.println(ch);
                node.eow[ch - 'a'] = true;
            }
            node = node.childs[ch - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        MyTrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (null == node.childs[ch - 'a']) {
                System.out.println(ch + " false");
                return false;
            }
            if (i == word.length() - 1 && node.eow[ch - 'a'] == true) {
                return true;
            }
            node = node.childs[ch - 'a'];
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        MyTrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            if (null == node.childs[ch - 'a']) {
                return false;
            }
            if (i == prefix.length() - 1) {
                return true;
            }
            node = node.childs[ch - 'a'];
        }
        return false;
    }

    public static class MyTrieNode {
        public boolean[] eow = new boolean[26];
        public MyTrieNode[] childs = new MyTrieNode[26];
    }
}
