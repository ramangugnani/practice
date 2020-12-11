package practice.leetcode.problems;

import practice.leetcode.may.week3.TreeNode;

public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        TreeNode t1Node5 = new TreeNode(5);
        TreeNode t1Node2 = new TreeNode(2);
        TreeNode t1Node3 = new TreeNode(3,t1Node5,null);
        TreeNode t1 = new TreeNode(1,t1Node3,t1Node2);

        TreeNode t2Node7 = new TreeNode(7);
        TreeNode t2Node4 = new TreeNode(4);
        
        TreeNode t2Node3 = new TreeNode(3,null,t2Node7);
        TreeNode t2Node1 = new TreeNode(1,null,t2Node4);
        TreeNode t2 = new TreeNode(2,t2Node1,t2Node3);

        System.out.println("=== T1 ===");
        print(t1);
        System.out.println("=== T2 ===");
        print(t2);
        TreeNode t = mergeTrees(t1, t2);
        System.out.println("=== T ===");
        print(t);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        } else if (null != t1 && null == t2) {
            return t1;
        } else if (null == t1 && null != t2) {
            return t2;
        } else {
            return new TreeNode(t1.val + t2.val,
                    mergeTrees(t1.left, t2.left),
                    mergeTrees(t1.right, t2.right));
        }
    }
    
    public static void print(TreeNode t) {
        if(null == t) {
            return;
        }else {
            System.out.println(t.val);
            if(null != t.left) {
                print(t.left);
            }
            if(null != t.right) {
                print(t.right);
            }
        }
    }
}
