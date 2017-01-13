package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/22.
 */
public class RecoverBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode first, second, pre = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }

    private static void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (first == null && root.val <= pre.val)
            first = pre;

        if (first != null && root.val <= pre.val)
            second = root;

        pre = root;
        traverse(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        root.left = n2;
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        n6.left = n5;
        n6.right = n7;
        root.right = n6;
        recoverTree(root);
    }
}
