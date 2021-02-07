package practice.leetcode.problems;

public class DesignCompressedStringIterator_604_Main {
    public static void main(String[] args) {
        DesignCompressedStringIterator_604 itr = new DesignCompressedStringIterator_604("a3b2c2");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
    }
}
