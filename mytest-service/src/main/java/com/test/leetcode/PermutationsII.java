package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/15.
 */
public class PermutationsII {

    /**
     * backtrace solution
     *
     * @param nums
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        boolean[] used = new boolean[nums.length];

        backtrace(res, new ArrayList<Integer>(), nums, 0, used);

        return res;
    }


    private static void backtrace(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start, boolean[] used) {
        if (tempList.size() == nums.length)
            res.add(new ArrayList<Integer>(tempList));  //add one permutation to result
        else {
            List<Integer> repeat = new ArrayList<Integer>();    //store repeat numbers
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || repeat.contains(nums[i])) continue;
                repeat.add(nums[i]);
                tempList.add(nums[i]);
                used[i] = true;
                backtrace(res, tempList, nums, start + 1, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    private static void printResult(List<List<Integer>> res) {
        if (res == null) return;
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        int[] nums = {};
        List<List<Integer>> res = permute(nums);
        System.out.println("find " + (res != null ? res.size() : 0) + " solutions");
        printResult(res);
    }
}
