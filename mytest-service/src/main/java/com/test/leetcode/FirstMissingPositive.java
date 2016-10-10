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

        if (sum - innerSum > 0)
            return sum - innerSum;
        else if (sum - innerSum == 0)
            return min == 1 ? max + 1 : 1;
        return -1;
    }


    //The basic idea is for any k positive numbers (duplicates allowed), the first missing positive number must be within [1,k+1].
    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int d = nums[i];
            while (d <= len && d > 0 && nums[d - 1] != d) {
                int t = nums[i];
                nums[i] = nums[d - 1];
                nums[d - 1] = t;
                d = nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 3, -1, 3, 4, 5, 0, 1, 2, 5};
        int[] nums1 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive2(nums));
    }

}
