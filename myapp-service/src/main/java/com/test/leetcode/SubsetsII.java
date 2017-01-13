package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int k = 0; k <= nums.length; k++) {
            dfs(res, new ArrayList<Integer>(), k, nums, 0);
        }
        return res;
    }

    private static void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int k, int[] nums, int i) {
        if (temp.size() == k)
            res.add(new ArrayList<Integer>(temp));
        else
            for (int j = i; j < nums.length; j++) {
                if (j > i && nums[j] == nums[j - 1]) continue;
                temp.add(nums[j]);
                dfs(res, temp, k, nums, j + 1);
                temp.remove(temp.size() - 1);
            }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> t : res) {
            System.out.println(Arrays.toString(t.toArray()));
        }
    }

}
