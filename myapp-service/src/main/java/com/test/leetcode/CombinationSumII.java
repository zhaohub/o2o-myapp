package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/8.
 */
public class CombinationSumII {

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

        obtainSubList(res, new ArrayList<Integer>(), target, candidates);

        return res;
    }

    /**
     * obtain sub list
     *
     * @param res
     * @param sum
     * @param subArray
     * @return
     */
    private static void obtainSubList(List<List<Integer>> res, List<Integer> tmpList, int sum, int[] subArray) {
        if (sum < 0) return;

        if (sum == 0)
            res.add(new ArrayList<Integer>(tmpList));
        else
            for (int i = 0; i < subArray.length; i++) {
                if (i > 0 && subArray[i] == subArray[i - 1]) continue;
                tmpList.add(tmpList.size(), subArray[i]);
                obtainSubList(res, tmpList, sum - subArray[i], Arrays.copyOfRange(subArray, i + 1, subArray.length));
                tmpList.remove(tmpList.size() - 1); //backtrace
            }
    }

    public static void main(String[] args) {
        int[] canidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = combinationSum(canidates, 8);
        if (res != null) {
            System.out.println("find  " + res.size() + " combinations:");
            for (List<Integer> list : res) {
                System.out.println(Arrays.toString(list.toArray()));
            }
        }
    }
}