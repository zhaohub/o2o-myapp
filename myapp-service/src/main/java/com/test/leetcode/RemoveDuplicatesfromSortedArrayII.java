package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/9.
 */
public class RemoveDuplicatesfromSortedArrayII {

    public static int removeDuplicates(int[] nums, int n) {
        int len = 1, pre = nums[0], counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                if (++counter < n) len++;
            } else {
                counter = 0;
                len++;
            }
            pre = nums[i];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(removeDuplicates(nums, 2));
    }
}
