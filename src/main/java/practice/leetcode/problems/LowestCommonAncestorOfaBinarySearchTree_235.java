package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class LowestCommonAncestorOfaBinarySearchTree_235 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node3 = new TreeNode(3);
        
        TreeNode root = new TreeNode(7,node3,node15);
        TreeNode result = lowestCommonAncestor(root, node9, root);
        System.out.println(result.val);
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = new TreeNode(Integer.MAX_VALUE);
        lowestCommonAncestorInner(root, p, q, result);
        return result;
    }
    
    public static boolean lowestCommonAncestorInner(TreeNode root, TreeNode p, TreeNode q,TreeNode result) {
        if(null == root) {
            return false;
        }else {
            boolean leftResult = false;
            boolean rightResult = false;
            if(null != root.left) {
                leftResult = lowestCommonAncestorInner(root.left, p, q, result);
            }
            
            if(null != root.right) {
                rightResult = lowestCommonAncestorInner(root.right, p, q, result);
            }
            //System.out.println(leftResult + " " + rightResult + " " + root.val);
            if(leftResult == true && rightResult == true && Integer.MAX_VALUE == result.val) {
                //System.out.println("here");
                result.val = root.val;
            }
            if((leftResult == true || rightResult == true) && (p.val == root.val || q.val == root.val)) {
                //System.out.println("here2");
                result.val = root.val;
            }
            return root.val == p.val || root.val == q.val || leftResult || rightResult;
        }
        
    } 
}
