package com.test.leetcode;


import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/11/29.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        int j = 0;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val == inorder[j]) {
                while (!stack.isEmpty() && (stack.peek().val == inorder[j])){
                    node = stack.pop();
                    j++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            } else {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 5, 2, 7, 8, 6, 9};
        int[] inorder = {2, 5, 7, 3, 6, 8, 9};
        TreeNode root = buildTree(preorder, inorder);
    }
}
