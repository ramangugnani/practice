package practice.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

import practice.leetcode.TreeNode;

public class MinimumDepthOfBinaryTree_111 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15);
        
        TreeNode node3 = new TreeNode(3,node9,node20);
        
        TreeNode root = new TreeNode(7,node3,node15);
        System.out.println(minDepth(null));
    }
    
    public static int minDepth(TreeNode root) {
        int level = 0;
        Queue<TreeNode> myQueue = new LinkedList<>();
        if(null == root) {
            return level;
        }
        myQueue.add(root);
        while(myQueue.size() > 0) {
            Integer size = myQueue.size();
            level++;
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = myQueue.poll();
                if(node.left == null && node.right == null) {
                    return level;
                }
                if(node.left != null) {
                    myQueue.add(node.left);
                }
                if(node.right != null) {
                    myQueue.add(node.right);
                }
            }
        }
        return level;
    }
}
