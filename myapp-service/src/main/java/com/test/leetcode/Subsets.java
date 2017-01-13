package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/8.
 */
public class Subsets {

    /**
     * backtrace solution
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int k = 0; k <= nums.length; k++) {
            dfs(res, new ArrayList<Integer>(), nums, k, 0);
        }
        return res;
    }

    private static void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, int k, int j) {
        if (temp.size() == k)
            res.add(new ArrayList<Integer>(temp));
        else
            for (int i = j; i < nums.length; i++) {
                temp.add(nums[i]);
                dfs(res, temp, nums, k, i + 1);
                temp.remove(temp.size() - 1);
            }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> t : res) {
            System.out.println(Arrays.toString(t.toArray()));
        }
    }
}
