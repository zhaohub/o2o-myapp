package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/14.
 */
public class JumpGameII {

    /**
     * 回溯法求解所有的路径
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        backtrace(res, tmpList, nums, 0);
        int min = Integer.MAX_VALUE;
        for (List<Integer> t : res) {
            if (t.size() < min)
                min = t.size();

            //print all route
            System.out.println(Arrays.toString(t.toArray()));
        }

        return min - 1 == 0 ? 1 : min - 1;
    }

    private static void backtrace(List<List<Integer>> res, List<Integer> tmpList, int[] nums, int startIndex) {
        if (startIndex > nums.length)
            return;
        if (startIndex == nums.length)
            res.add(new ArrayList<Integer>(tmpList));
        else {
            tmpList.add(startIndex);
            for (int j = 1; j <= nums[startIndex]; j++) {
                if (startIndex + j <= nums.length) {
                    backtrace(res, tmpList, nums, startIndex + j);
                }
            }
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 4};
        System.out.println(jump(nums));
    }
}
