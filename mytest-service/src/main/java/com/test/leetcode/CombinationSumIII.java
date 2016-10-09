package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/8.
 */
public class CombinationSumIII {

    /**
     * backtracing solution
     *
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracing(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    private static void backtracing(List<List<Integer>> res, List<Integer> cmb, int k, int target, int index) {
        if (target < 0) return;

        if (target == 0 && cmb.size() == k) {
            res.add(new ArrayList<Integer>(cmb));
        } else
            for (int i = index; i <= 9; i++) {
                cmb.add(i);
                backtracing(res, cmb, k, target - i, i + 1);  //if last parameter is i,that numbers can repeat any times in result
                cmb.remove(cmb.size() - 1);
            }
    }

    /**
     * k sum solution
     *
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum31(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        return FourSum.kSum(k, nums, n, 0);
    }


    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum31(3, 9);
        res = combinationSum3(20, 100);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
