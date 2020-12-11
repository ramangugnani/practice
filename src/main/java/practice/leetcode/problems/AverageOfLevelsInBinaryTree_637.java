package practice.leetcode.problems;

import java.util.*;

import practice.leetcode.may.week3.TreeNode;

public class AverageOfLevelsInBinaryTree_637 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node3 = new TreeNode(3);
        
        TreeNode root = new TreeNode(7,node3,node15);
        System.out.println(averageOfLevels(root));
    }
    
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        List<Double> answer = new ArrayList<Double>();
        
        myQueue.add(root);
        
        while(myQueue.size() > 0) {
            Double sum = 0d;
            Integer size = myQueue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode node = myQueue.poll();
                sum = sum + node.val;
                if (null != node.left) {
                    myQueue.add(node.left);
                }
                if (null != node.right) {
                    myQueue.add(node.right);
                }
            }
            answer.add(sum/size);
        }
        return answer;
    }
}
