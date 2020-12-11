package practice.leetcode.problems;

import practice.leetcode.may.week3.TreeNode;

public class SubtreeOfAnotherTree_572 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node3 = new TreeNode(3);
        
        TreeNode root = new TreeNode(7,node3,node15);
        
        TreeNode node4 = new TreeNode(21);
        
        System.out.println(isSubtree(root,node3));
        
    }
    
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = mainTree(s,t);
        return result;
    }
    
    public static boolean mainTree(TreeNode s, TreeNode t) {
        boolean result = false;
        result = compare(s,t);
        if(result) {
            return result;
        }
        if (null != s.left) {
            result = mainTree(s.left, t);
            if(result) {
                return result;
            }
        }
        if (null != s.right) {
            result = mainTree(s.right, t);
        }
        return result;
    }
    
    public static boolean compare(TreeNode s, TreeNode t) {
        if(null == s && null == t) {
            return true;
        }else if (null == s || null == t) {
            // if anyone is null and another not return false
            return false;
        }else {
            return s.val == t.val && compare(s.left, t.left) && compare(s.right, t.right);
        }
    }
}
