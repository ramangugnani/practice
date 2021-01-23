package practice.leetcode.problems;

import practice.leetcode.TreeNode;

public class SerializeandDeserializeBinaryTree_297_Main {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(3, node4, node5);

        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println("INPUT");
        print(node1);

        SerializeandDeserializeBinaryTree_297 codec = new SerializeandDeserializeBinaryTree_297();

        String ans = codec.serialize(node1);
        System.out.println("DES --> " + ans);

        TreeNode root = codec.deserialize(ans);
        System.out.println("OUTPUT");
        print(root);

        ans = codec.serialize(node4);
        System.out.println("DES --> " + ans);

        root = codec.deserialize(ans);
        System.out.println("OUTPUT");
        print(root);
        
        ans = codec.serialize(null);
        System.out.println("DES --> " + ans);

        root = codec.deserialize(ans);
        System.out.println("OUTPUT");
        print(root);

    }

    public static void print(TreeNode root) {
        if (null == root) {
            return;
        } else {
            System.out.println(root.val);
            print(root.left);
            print(root.right);
        }
    }
}
