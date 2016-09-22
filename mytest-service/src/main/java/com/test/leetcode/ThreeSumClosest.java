package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/21.
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null)
            throw new NullPointerException();

        int len = nums.length, closest = 0;

        if (len < 3)
            throw new IllegalArgumentException("nums length is" + len);
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int l = i + 1, h = len - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (Math.abs(sum - target) <= Math.abs(closest - target)) {
                    closest = sum;
                    if (sum == target) return closest;
                }
                if (sum > target)
                    h--;
                else
                    l++;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 90));
    }
}
