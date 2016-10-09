package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/9.
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        int innerSum = 0, max = nums[0], min = Integer.MAX_VALUE;

        outer:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                continue;

            int j = 0;
            while (j < i) {   //skip repeat integer
                if (i > 0 && nums[i] == nums[i - ++j])
                    continue outer;
            }

            innerSum += nums[i];

            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        innerSum = innerSum - max - min;

        int sum = 0;
        for (int j = min + 1; j < max; j++) {
            sum += j;
        }

        int res = 0;
        if (sum - innerSum > 0)
            res = sum - innerSum;
        else if (sum - innerSum == 0)
            res = min == 1 ? max + 1 : 1;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 3, -1, 3, 4, 5, 0, 1, 2, 5};
        int[] nums1 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

}
