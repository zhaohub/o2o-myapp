package com.test.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaogang3 on 2017/1/9.
 */
public class PathSumII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        pathSum(root, sum, temp, result);
        return result;
    }

    private static void pathSum(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (root == null) return;
        temp.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<Integer>(temp));
            temp.remove(temp.size() - 1);
            return;
        } else {
            pathSum(root.left, sum - root.val, temp, result);
            pathSum(root.right, sum - root.val, temp, result);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n4.left = n7;
        n4.right = n8;

        n3.left = n5;
        n3.right = n6;
        n6.left = n9;
        n6.right = n10;
        List<List<Integer>> result = pathSum(n1, 22);
    }
}
