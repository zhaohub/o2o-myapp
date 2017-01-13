package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/21.
 */
public class MaximumSubarray {

    /**
     * o(n2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /**
     * o(n)solution
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 1, -5, 4, -1, 2, 1, -3, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));
    }


}
