package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import practice.leetcode.TreeNode;

public class AllNodesDistanceKInBinaryTree_863 {

    public static void main(String[] args) {
        /*
         * 0 2 1 3
         */
        TreeNode node_5_10 = new TreeNode(10);

        TreeNode node_4_7 = new TreeNode(7, node_5_10, null);
        TreeNode node_4_4 = new TreeNode(4);

        TreeNode node_3_6 = new TreeNode(6);
        TreeNode node_3_2 = new TreeNode(2, node_4_7, node_4_4);
        TreeNode node_3_0 = new TreeNode(0);
        TreeNode node_3_8 = new TreeNode(8);

        TreeNode node_2_5 = new TreeNode(5, node_3_6, node_3_2);
        TreeNode node_2_1 = new TreeNode(1, node_3_0, node_3_8);

        TreeNode node_1_3 = new TreeNode(3, node_2_5, node_2_1);

        System.out.println(distanceK(node_1_3, node_2_5, 2));

        System.out.println(distanceK(node_1_3, node_3_6, 2));

        System.out.println(distanceK(node_1_3, node_3_6, 1));

        System.out.println(distanceK(node_5_10, node_5_10, 3));

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> nodes = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(root, target, nodes, temp);
        Map<Integer, Integer> nodeByHeight = new HashMap<>();
        Integer j = 0;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            nodeByHeight.put(nodes.get(i), j++);
        }
        // System.out.println(nodeByHeight);
        List<Integer> ans = new ArrayList<>();
        dfsNew(root, K, nodeByHeight, nodeByHeight.get(root.val), ans);
        return ans;
    }

    private static void dfsNew(TreeNode root, int k, Map<Integer, Integer> nodeByHeight, Integer currentHeight,
            List<Integer> ans) {
        if (null == root) {
            return;
        } else {
            if (nodeByHeight.containsKey(root.val)) {
                currentHeight = nodeByHeight.get(root.val);
            }
            // System.out.println(root.val + " --> " + currentHeight);
            if (currentHeight == k) {
                ans.add(root.val);
            }
            dfsNew(root.left, k, nodeByHeight, currentHeight + 1, ans);
            dfsNew(root.right, k, nodeByHeight, currentHeight + 1, ans);
        }

    }

    private static void dfs(TreeNode root, TreeNode target, List<Integer> nodes, List<Integer> temp) {
        if (null == root) {
            return;
        } else {
            temp.add(root.val);
            if (root.val == target.val) {
                // copy all the nodes
                nodes.addAll(temp);
            }
            dfs(root.left, target, nodes, temp);
            dfs(root.right, target, nodes, temp);
            temp.remove(temp.size() - 1);
        }

    }

}
