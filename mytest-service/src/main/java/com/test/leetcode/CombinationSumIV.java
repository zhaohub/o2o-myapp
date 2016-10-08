package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogang3 on 2016/10/8.
 */
public class CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        Map<String, Integer> map = new HashMap();
        map.put("size", 0);
        backtrace(map, new ArrayList<Integer>(), nums, 0, target);
        return map.get("size");
    }

    private static void backtrace(Map<String, Integer> map, ArrayList<Integer> tmp, int[] nums, int start, int target) {
        if (target < 0) return;
        if (target == 0) map.put("size", map.get("size") + 1);

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrace(map, tmp, nums, start, target - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * some better solution
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum41(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum41(nums, target - nums[i]);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
        System.out.println(combinationSum41(nums, 4));

    }

}
