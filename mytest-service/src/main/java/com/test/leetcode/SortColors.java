package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/11/5.
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0) {
                if (nums[j] > nums[j - 1])
                    break;
                else if (nums[j] < nums[j - 1])
                    swap(nums, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[] nums, int m, int n) {
        int t = nums[m];
        nums[m] = nums[n];
        nums[n] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 2, 0, 0, 1, 2, 1, 1, 0, 0, 1, 0, 2, 0, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
