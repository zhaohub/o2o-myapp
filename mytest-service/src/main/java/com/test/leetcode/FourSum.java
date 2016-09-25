package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/9/23.
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return null;
        return kSum(4, nums, target, 0);
    }

    private static ArrayList<List<Integer>> kSum(int k, int[] nums, int target, int index) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 2) {
            int l = index, h = nums.length - 1;
            while (l < h) {
                int t = nums[l] + nums[h];
                if (t == target) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[l]);
                    tmp.add(nums[h]);
                    res.add(tmp);
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                }
                if (t < target) l++;
                if (t > target) h--;
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                ArrayList<List<Integer>> tmp = kSum(k - 1, nums, target - nums[i], i + 1);
                if (tmp != null) {
                    for (List<Integer> t : tmp) {
                        //add current
                        t.add(nums[i]);
                    }

                    res.addAll(tmp);
                }

                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;    //skip dumplicate numbers;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum(nums, 0);
    }
}
