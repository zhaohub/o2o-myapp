package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/20.
 */
public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return true;

        if (minNode != null && minNode.val >= root.val || maxNode != null && maxNode.val <= root.val)
            return false;

        return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(isValidBST(n1));

    }

}



