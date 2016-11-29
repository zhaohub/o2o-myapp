package com.test.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/29.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offerLast(root);

        boolean moveRight = false;
        while (!deque.isEmpty()) {
            List<Integer> ans = new ArrayList<Integer>();
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (moveRight) {
                    if (node.left != null) deque.offerLast(node.left);
                    if (node.right != null) deque.offerLast(node.right);
                } else {
                    if (node.right != null) deque.offerLast(node.right);
                    if (node.left != null) deque.offerLast(node.left);
                }
                ans.add(node.val);
            }
            if (moveRight)
                moveRight = false;
            else
                moveRight = true;

            res.add(ans);
        }
        return res;
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
        List<List<Integer>> res = zigzagLevelOrder(n1);
    }
}
