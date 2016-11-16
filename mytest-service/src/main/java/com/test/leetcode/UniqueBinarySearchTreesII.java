package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/15.
 */
public class UniqueBinarySearchTreesII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();

        dfs(res, new ArrayList<Integer>(), n, 1);

        return res;
    }

    private static void dfs(List<TreeNode> res, List<Integer> temp, int n, int k) {
        if (k == n + 1)
            res.add(constructTreeFromList(temp));
        else {
            for (int i = 1; i <= n; i++) {
                if (temp.contains(i)) continue;
                temp.add(i);
                dfs(res, temp, n, k + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static TreeNode constructTreeFromList(List<Integer> temp) {
        System.out.println(Arrays.toString(temp.toArray()));
        TreeNode node = new TreeNode(temp.get(0)), root = node;  //第一个作为根
        for (int i = 1; i < temp.size(); i++) {
            int pre = temp.get(i - 1);
            if (temp.get(i) < pre) {
                while (node.left != null) {
                    node = node.left;
                }
                node.left = new TreeNode(temp.get(i));
            } else {
                while (node.right != null) {
                    node = node.right;
                }
                node.right = new TreeNode(temp.get(i));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
    }
}
