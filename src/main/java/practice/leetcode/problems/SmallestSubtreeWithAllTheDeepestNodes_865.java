package practice.leetcode.problems;

import java.util.*;

import practice.leetcode.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);

        
        TreeNode node9 = new TreeNode(9,node8,null);
        TreeNode node20 = new TreeNode(20);

        TreeNode node15 = new TreeNode(15,node9,node20);
        
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3,node1,null);
        
        TreeNode root = new TreeNode(7,node3,node15);
        TreeNode newroot = subtreeWithAllDeepest(root);
        
        print(newroot);
    }
        
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        if (null == root) {
            return null;
        }
        myQueue.add(root);
        Set<Integer> deepestNodes = new HashSet<>();
        while(myQueue.size() > 0) {
            deepestNodes.clear();
            int size = myQueue.size();
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = myQueue.poll();
                deepestNodes.add(node.val);
                
                if(null != node.left) {
                    myQueue.add(node.left);
                }
                if(null != node.right) {
                    myQueue.add(node.right);
                }
                
            }
        }
        System.out.println(deepestNodes);
        BigTreeNode newRoot = postOrder(root,deepestNodes);
        System.out.println(newRoot.treeNode.val);
        return newRoot.treeNode;
    }
    
    public static BigTreeNode postOrder(TreeNode root,Set<Integer> deepestNodes) {
        if(null == root) {
            return null;
        }else {
            BigTreeNode leftRoot = null;
            if(null != root.left) {
                leftRoot = postOrder(root.left,deepestNodes);
            }
            
            BigTreeNode rightRoot = null;
            if(null != root.right) {
                rightRoot = postOrder(root.right,deepestNodes);
            }
            
            if(deepestNodes.contains(root.val)) {
                BigTreeNode node = new BigTreeNode();
                node.treeNode = root;
                node.count = 1;
                return node;
            } 
            
            if (null != leftRoot && leftRoot.count == deepestNodes.size()) {
                return leftRoot;
            }
            
            if (null != rightRoot && rightRoot.count == deepestNodes.size()) {
                return rightRoot;
            }
            
            BigTreeNode node = new BigTreeNode();
            node.treeNode = root;
            if(null != leftRoot) {
                node.count =  node.count + leftRoot.count;
            }else {
                root.left = null;
            }
            if( null != rightRoot) {
                node.count =  node.count + rightRoot.count;
            }else {
                root.right = null;
            }
            return node;
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
    
    public static class BigTreeNode{
        public TreeNode treeNode;
        public Integer count = 0;
    }
}
