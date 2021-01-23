package practice.leetcode.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream_703 {
    Queue<Integer> q = null;
    int length = 0;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        q = new PriorityQueue<>(k);
        length = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        //System.out.println(val + " --> " + q);
        if (q.size() == length) {
            if (q.peek() > val) {
                return q.peek();
            } else {
                q.poll();
                q.add(val);
                return q.peek();
            }
        } else {
            q.add(val);
            return q.peek();
        }
    }
}
