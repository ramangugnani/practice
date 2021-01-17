package practice.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray_215 {
    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));

        System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));

        System.out.println(findKthLargestGood(new int[] { 3, 2, 1, 5, 6, 4 }, 2));

        System.out.println(findKthLargestGood(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));

        System.out.println(findKthLargestHeap(new int[] { 3, 2, 1, 5, 6, 4 }, 2));

        System.out.println(findKthLargestHeap(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));

    }

    public static int findKthLargest(int[] nums, int k) {
        int answer = 0;
        Arrays.sort(nums);
        int j = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (j == k) {
                answer = nums[i];
                break;
            }
            j++;
        }
        return answer;
    }

    public static int findKthLargestGood(int[] nums, int k) {
        if (nums.length < 0 || k < 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargestHeap(int[] nums, int k) {
        if (nums.length < 0 || k < 0) {
            return -1;
        }
        Queue<Integer> heap = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int j = 1; j < k; j++) {
            heap.poll();
        }
        return heap.peek();
    }

    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }
}
