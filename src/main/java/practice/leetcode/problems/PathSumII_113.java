package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

import practice.leetcode.TreeNode;

public class PathSumII_113 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4 = new TreeNode(4, node5, node1);

        TreeNode node_4 = new TreeNode(4, node11, null);
        TreeNode node8 = new TreeNode(8, node13, node4);
        TreeNode node_5 = new TreeNode(5, node_4, node8);

        System.out.println(pathSum(node_5, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        traverse(root, targetSum, new ArrayList<>(), answer);
        return answer;
    }

    public static void traverse(TreeNode root, Integer targetSum, List<Integer> tempList, List<List<Integer>> answer) {
        if (null == root) {
            return;
        }
        tempList.add(root.val);
        targetSum = targetSum - root.val;
        if (null == root.left && null == root.right && 0 == targetSum) {
            answer.add(new ArrayList<>(tempList));
        } else {
            traverse(root.left, targetSum, tempList, answer);
            traverse(root.right, targetSum, tempList, answer);
        }
        tempList.remove(tempList.size() - 1);
    }
}
