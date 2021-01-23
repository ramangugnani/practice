package practice.leetcode.problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import practice.leetcode.TreeNode;

public class SerializeandDeserializeBinaryTree_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preOrder(root,str);
        return str.toString();
    }

    private void preOrder(TreeNode root, StringBuilder str) {
        if(null == root) {
            str.append("1001,");
        }else {
            str.append(root.val+",");
            preOrder(root.left, str);
            preOrder(root.right, str);
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data || data.length() == 0) {
            return null;
        }
        else {
            data = data.substring(0, data.length() - 1);
            //System.out.println("data " + data);
        }
        String[] nodeStr = data.split(",");
        Deque<String> q = new LinkedList<>(Arrays.asList(nodeStr));
        return buildTree(q);

    }

    private TreeNode buildTree(Deque<String> q) {
        String v = q.remove();
        Integer val = Integer.valueOf(v);
        if(val == 1001) {
            return null;
        }else {
            TreeNode node = new TreeNode(val);
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }

}
