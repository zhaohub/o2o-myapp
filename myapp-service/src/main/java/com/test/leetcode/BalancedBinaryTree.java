package com.test.leetcode;

/**
 * Created by zhaogang3 on 2017/1/4.
 */
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算树的深度
     *
     * @param root
     * @return
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n3.left = n1;
        n3.right = n2;
        n4.left = n3;
        n4.right = n5;
        //n5.left = new TreeNode(1);
        n5.right = n6;
        System.out.println(isBalanced(n4));
    }
}
