package practice.leetcode.problems;

public class KthLargestElementInAStream_703_Main {
    public static void main(String[] args) {
        KthLargestElementInAStream_703 kthLargest = new KthLargestElementInAStream_703(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8
    }
}
