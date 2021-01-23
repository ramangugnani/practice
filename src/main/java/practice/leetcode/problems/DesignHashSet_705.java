package practice.leetcode.problems;

public class DesignHashSet_705 {
    /** Initialize your data structure here. */
    boolean[] myList = null;

    public DesignHashSet_705() {
        myList = new boolean[1000001];
    }

    public void add(int key) {
        myList[key] = true;
    }

    public void remove(int key) {
        myList[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return myList[key];
    }
}
