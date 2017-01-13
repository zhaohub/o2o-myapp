package com.test.leetcode;

import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/11/28.
 */
public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean symmetric = false;

    public static boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        traverseLeft(stack, root.left);
        traverseRight(stack, root.right);
        return symmetric;
    }

    private static void traverseLeft(Stack<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        traverseLeft(stack, root.left);
        stack.push(root);
        traverseLeft(stack, root.right);
    }

    private static void traverseRight(Stack<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        traverseRight(stack, root.left);
        TreeNode node = stack.pop();
        if (node != null && node.val == root.val)
            symmetric = true;
        traverseRight(stack, root.right);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n6;

        n3.left = n5;
        n3.right = n7;
        System.out.println(isSymmetric(n1));
    }
}
