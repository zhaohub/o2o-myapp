package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/8.
 */
public class CombinationSum {

    /**
     * combination sum
     *
     * @param candidates must be positive
     * @param target     must be positive
     * @return unique combinations
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);    //sort candidates
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = candidates.length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<Integer>();
            if (obtainSubList(list, target - candidates[i], Arrays.copyOfRange(candidates, 0, i + 1))) {
                list.add(candidates[i]);
                res.add(list);  //find a sum list,add to result
            }
        }
        return res;
    }

    /**
     * obtain sub list
     * may count less
     *
     * @param res
     * @param sum
     * @param subArray
     * @return
     */
    private static boolean obtainSubList(List<Integer> res, int sum, int[] subArray) {
        if (subArray == null || subArray.length == 0)
            return false;

        for (int i = subArray.length - 1; i >= 0; i--) {
            if (sum == subArray[i] ||
                    (subArray[i] < sum && obtainSubList(res, sum - subArray[i], Arrays.copyOfRange(subArray, 0, i + 1)))) {
                res.add(subArray[i]);
                return true;
            }
        }
        return false;
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //dfs solution
        backtrace(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    private static void backtrace(List<List<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0)    //find a combination, add to result
            res.add(new ArrayList<Integer>(tmp));

        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtrace(res, tmp, candidates, start, remain - candidates[i]);
            tmp.remove(tmp.size() - 1);   //remove current visited node,turn to sibling node
        }
    }

    private static void printResult(List<List<Integer>> res) {
        if (res != null) {
            System.out.println("find " + res.size() + " combinations:");
            for (List<Integer> list : res) {
                System.out.println(Arrays.toString(list.toArray()));
            }
        }
    }

    public static void main(String[] args) {
        int[] canidates = {1, 2, 3, 6, 7, 5};
        printResult(combinationSum2(canidates, 9));
        printResult(combinationSum(canidates, 9));
    }
}