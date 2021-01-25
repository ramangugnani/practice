package practice.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

import practice.leetcode.TreeNode;

public class PathSumIII_437 {

    public static void main(String[] args) {
        TreeNode node_4_3 = new TreeNode(3);
        TreeNode node_4_2 = new TreeNode(-2);
        TreeNode node_4_1 = new TreeNode(1);

        TreeNode node_3_3 = new TreeNode(3, node_4_3, node_4_2);
        TreeNode node_3_2 = new TreeNode(2, null, node_4_1);
        TreeNode node_3_11 = new TreeNode(11);

        TreeNode node_2_5 = new TreeNode(5, node_3_3, node_3_2);
        TreeNode node_2_3 = new TreeNode(-3, null, node_3_11);

        TreeNode node_10 = new TreeNode(10, node_2_5, node_2_3);

        System.out.println(pathSum(node_10, 8));
    }

    public static Integer pathSum(TreeNode root, int sum) {
        Integer answer = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        answer = traverse(root, 0, sum, preSum);
        return answer;
    }

    private static Integer traverse(TreeNode root, int sum, int targetSum, Map<Integer, Integer> preSum) {
        if (null == root) {
            return 0;
        } else {
            //System.out.println(root.val + " --> " + preSum);
            sum += root.val;
            // check if any count exists for total sum == 0 in pre Sum hash
            Integer count = preSum.getOrDefault(sum - targetSum, 0);

            // update the current Sum hash
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

            // check below for child nodes
            count += traverse(root.left, sum, targetSum, preSum);
            count += traverse(root.right, sum, targetSum, preSum);

            // remove current Sum Hash
            preSum.put(sum, preSum.get(sum) - 1);

            return count;
        }
    }

}
