package practice.leetcode.problems;

import practice.leetcode.Trie;

public class ImplementTriePrefixTree_208 {
    public static void main(String[] args) {
        /**
         * Your Trie object will be instantiated and called as such:
         */
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }

}
