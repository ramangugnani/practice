package practice.leetcode.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int[] ans = topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
        System.out.println();
        ans = topKFrequent(new int[] { 1 }, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<MyNode> myQ = new PriorityQueue<MyNode>(new MyNodeComp());
        Map<Integer, MyNode> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                MyNode node = myMap.get(nums[i]);
                myQ.remove(node);
                MyNode newNode = new MyNode();
                newNode.num = node.num;
                newNode.freq = node.freq + 1;
                myQ.add(newNode);
                myMap.put(nums[i], newNode);
            } else {
                MyNode newNode = new MyNode();
                newNode.num = nums[i];
                newNode.freq = 1;
                myQ.add(newNode);
                myMap.put(nums[i], newNode);
            }
            // System.out.println(myMap);
        }
        for (int i = 0; i < k; i++) {
            MyNode node = myQ.poll();
            ans[i] = node.num;
        }
        return ans;
    }

    public static class MyNode {
        public int num;
        public int freq;
    }

    public static class MyNodeComp implements Comparator<MyNode> {
        public int num;
        public int freq;

        @Override
        public int compare(MyNode o1, MyNode o2) {
            int ans = o2.freq - o1.freq;
            if (ans == 0) {
                ans = o1.num - o2.num;
            }
            return ans;
        }

    }
}
