package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/12/19.
 */
public class ConvertSortedArraytoBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return arrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode arrayToBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = arrayToBST(nums, low, mid - 1);
        node.right = arrayToBST(nums, mid + 1, high);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode node = sortedArrayToBST(nums);
    }
}
