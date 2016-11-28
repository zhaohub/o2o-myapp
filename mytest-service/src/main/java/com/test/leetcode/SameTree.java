package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/28.
 */
public class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if ((p != null && q != null) && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        n1.left = new TreeNode(1);
        n1.right = new TreeNode(3);

        TreeNode n2 = new TreeNode(2);
        n2.left = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.right = n3;
        n3.left = new TreeNode(2);

        System.out.println(isSameTree(n1, n2));
    }

}
