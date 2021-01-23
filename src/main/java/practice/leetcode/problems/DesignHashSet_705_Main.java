package practice.leetcode.problems;

public class DesignHashSet_705_Main {
    public static void main(String[] args) {
        DesignHashSet_705 hashSet = new DesignHashSet_705();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)); // returns true
        System.out.println(hashSet.contains(3)); // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2)); // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2)); // returns false (already removed)
    }
}
