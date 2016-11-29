package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/29.
 */
public class MaximumDepthofBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n3.right = n5;

        n4.left = n6;
        n4.right = n7;

        System.out.println(maxDepth(n1));
    }
}
