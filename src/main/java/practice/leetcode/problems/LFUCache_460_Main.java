package practice.leetcode.problems;

public class LFUCache_460_Main {
    public static void main(String[] args) {
        // LFUCache_460 lfu = new LFUCache_460(2);
        // lfu.put(1, 1);
        // lfu.put(2, 2);
        // System.out.println(lfu.get(1)); // return 1
        // lfu.put(3, 3); // evicts key 2
        // System.out.println(lfu.get(2)); // return -1 (not found)
        // System.out.println(lfu.get(3)); // return 3
        // lfu.put(4, 4); // evicts key 1.
        // System.out.println(lfu.get(1)); // return -1 (not found)
        // System.out.println(lfu.get(3)); // return 3
        // System.out.println(lfu.get(4)); // return 4

        LFUCache_460 lfu = new LFUCache_460(3);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.put(4, 4);
        System.out.println("ANS 4 --> " + lfu.get(4));
        System.out.println("ANS 3 --> " + lfu.get(3));
        System.out.println("ANS 2 --> " + lfu.get(2));
        System.out.println("ANS 1 --> " + lfu.get(1));
        lfu.put(5, 5);
        System.out.println("ANS 1 --> " + lfu.get(1));
        System.out.println("ANS 2 --> " + lfu.get(2));
        System.out.println("ANS 3 --> " + lfu.get(3));
        System.out.println("ANS 4 --> " + lfu.get(4));
        System.out.println("ANS 5 --> " + lfu.get(5));

    }
}
