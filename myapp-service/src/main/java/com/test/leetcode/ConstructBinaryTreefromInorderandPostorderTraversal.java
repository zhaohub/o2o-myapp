package com.test.leetcode;

import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/12/3.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);

        int i = inorder.length - 1;
        int j = postorder.length - 2;

        for (; j >= 0; j--) {
            TreeNode node = stack.peek();

            if (node.val == inorder[i]) {
                while (!stack.isEmpty() && (stack.peek().val == inorder[i])) {
                    node = stack.pop();
                    i--;
                }
                node.left = new TreeNode(postorder[j]);
                stack.push(node.left);
            } else {
                node.right = new TreeNode(postorder[j]);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {2, 5, 7, 3, 6, 8, 9};
        int[] postorder = {2, 7, 5, 6, 9, 8, 3};
        TreeNode root = buildTree(inorder, postorder);
    }
}
