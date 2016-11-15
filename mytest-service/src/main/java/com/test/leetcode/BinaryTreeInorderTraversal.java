package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/11/15.
 */
public class BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(res, root);
        return res;
    }

    private static void inorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        while (cur != null || !toVisit.isEmpty()) {
            if (cur == null) {
                TreeNode node = toVisit.pop();
                res.add(node.val);
                cur = node.right;
            } else {
                toVisit.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        //n1.left = null;
        n1.right = n2;
        n2.left = n3;
        List<Integer> res = inorderTraversal(n1);
        List<Integer> res1 = inorderTraversal1(n1);
    }

}
