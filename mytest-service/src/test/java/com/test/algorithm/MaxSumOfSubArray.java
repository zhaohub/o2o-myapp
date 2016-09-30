package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogang3 on 2016/9/30.
 */
public class MaxSumOfSubArray {

    public static Map<String, Integer> maxSumOfSubArray(int[] nums) {
        Map<String, Integer> res = new HashMap<String, Integer>();
        int start = 0, end = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }
        res.put("max", max);
        res.put("start", start);
        res.put("end", end);
        return res;
    }

    public static int maxSumOfSubArray1(int[] nums) {
        if (nums == null && nums.length == 0)
            throw new IllegalArgumentException();

        int sum = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, -5, 10, -3, 2};
        Map<String, Integer> res = maxSumOfSubArray(nums);
        System.out.println(res.get("max"));
        System.out.println(maxSumOfSubArray1(nums));
    }
}