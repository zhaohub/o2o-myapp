package com.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogang3 on 2016/9/15.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 11, 15};
        int[] res = towSum(nums, 14);
    }

    private static int[] towSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length < 2) return result;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                result[0] = i;
                result[1] = map.get(a);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
