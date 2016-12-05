package com.test.leetcode;

import java.util.*;

/**
 * Created by zhaogang3 on 2016/12/3.
 */
public class BinaryTreeLevelOrderTraversalII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()) {
            List<Integer> ls = new ArrayList<Integer>();

            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode nd = queue.poll();
                if (nd.left != null) queue.add(nd.left);
                if (nd.right != null) queue.add(nd.right);
                ls.add(nd.val);
            }
            res.add(0, ls);
        }

        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        for (int i = 0; i < 5000000; i++) {
            map.put(i, new Object());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
