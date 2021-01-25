package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.leetcode.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public static void main(String[] args) {

        TreeNode node_5 = new TreeNode(5);
        TreeNode node_4 = new TreeNode(4);

        TreeNode node_2 = new TreeNode(2, null, node_5);
        TreeNode node_3 = new TreeNode(3, null, node_4);

        TreeNode root = new TreeNode(1, node_2, node_3);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        Queue<TreeNode> myQ = new LinkedList<>();
        myQ.add(root);
        Integer level = 0;
        while (myQ.size() > 0) {
            Integer size = myQ.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = myQ.poll();
                tempList.add(node.val);

                if (null != node.left) {
                    myQ.add(node.left);
                }

                if (null != node.right) {
                    myQ.add(node.right);
                }
            }
            if (level % 2 == 0) {
                ans.add(tempList);
            } else {
                List<Integer> tempRevList = new ArrayList<>();
                for (int j = tempList.size() - 1; j >= 0; j--) {
                    tempRevList.add(tempList.get(j));
                }
                ans.add(tempRevList);
            }
            level++;
        }
        return ans;
    }
}
