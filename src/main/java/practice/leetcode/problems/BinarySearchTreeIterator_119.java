package practice.leetcode.problems;

import java.util.*;

import practice.leetcode.TreeNode;

public class BinarySearchTreeIterator_119 {
    
    private Stack<TreeNode> mystack = null;
    
    public BinarySearchTreeIterator_119(TreeNode root) {
        TreeNode itr = root;
        mystack = new Stack<>();
        while(itr != null) {
            mystack.push(itr);
            itr = itr.left;
        }
    }
    
    public int next() {
        TreeNode element = mystack.pop();
        if (element.right != null) {
            mystack.push(element.right);
            TreeNode itr = element.right.left;
            while(itr != null) {
                mystack.push(itr);
                itr = itr.left;
            }
        }
        return element.val;
    }
    
    public boolean hasNext() {
        return mystack.isEmpty() ? false : true;
    }
    
    public void print(TreeNode root) {
        if(root == null) {
            return;
        }else {
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
    }
    
}
