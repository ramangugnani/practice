package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class SameTree_100 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node3 = new TreeNode(3);
        
        TreeNode root = new TreeNode(7,node3,node15);
        System.out.println(isSameTree(root, root));
        System.out.println(isSameTree(root, node3));
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p!= null && q != null){
            return p.val == q.val && isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
