package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/9/21.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] > 0 || nums[len - 1] <= 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i + 1, h = len - 1;
            while (l < h) {
                if (nums[l] + nums[h] == target) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                } else if (nums[l] + nums[l] < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
    }
}
