package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/14.
 */
public class Permutations {

    /**
     * dfs solution
     *
     * @param nums
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];

        dfs(res, tempList, nums, 0, used);

        return res;
    }


    private static void dfs(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start, boolean[] used) {
        if (tempList.size() == nums.length)
            res.add(new ArrayList<Integer>(tempList));
        else
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    tempList.add(nums[i]);
                    used[i] = true;
                    dfs(res, tempList, nums, start + 1, used);
                    tempList.remove(tempList.size() - 1);
                    used[i] = false;
                }
            }
    }

    private static void printResult(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printResult(permute(nums));
    }
}
