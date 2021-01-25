package practice.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

    public static void main(String[] args) {
        int[][] ans = kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "," + ans[i][1]);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<MyNode> myQ = new PriorityQueue<>(new MyNodeComp());
        for (int i = 0; i < points.length; i++) {
            MyNode node = new MyNode();
            node.x = points[i][0];
            node.y = points[i][1];
            node.dist = (node.x * node.x) + (node.y * node.y);
            myQ.add(node);
        }
        for (int i = 0; i < K; i++) {
            MyNode node = myQ.poll();
            ans[i][0] = node.x;
            ans[i][1] = node.y;
        }
        return ans;
    }

    public static class MyNode {
        public int x;
        public int y;
        public int dist;

    }

    public static class MyNodeComp implements Comparator<MyNode> {

        @Override
        public int compare(MyNode o1, MyNode o2) {
            return o1.dist - o2.dist;
        }

    }
}
