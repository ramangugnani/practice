package practice.leetcode.problems;

import java.util.*;

import practice.leetcode.may.week3.TreeNode;

public class BinaryTreeLevelOrderTraversalII_107 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node3 = new TreeNode(3);
        
        TreeNode root = new TreeNode(7,node3,node15);
        System.out.println(levelOrderBottom(root));
    }
    
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> myList = new LinkedList<>();
        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
        if(root == null) {
            return myList;
        }else {
            myQueue.add(root);
            
            while(myQueue.size() > 0) {
                Integer size = myQueue.size();
                List<Integer> levelList = new LinkedList<Integer>();
                for(int i = 0 ; i < size; i++) {
                    TreeNode node = myQueue.poll();
                    levelList.add(node.val);
                    
                    if(null != node.left) {
                        myQueue.add(node.left);
                    }
                    if(null != node.right) {
                        myQueue.add(node.right);
                    }
                }
                myList.add(0, levelList);
            }
        }
        return myList;
    }
}
