package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/26.
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException("nums is null or length is 0");

        Arrays.sort(nums);

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == val)
                slow = Math.min(slow, fast);
            else
                nums[slow++] = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args){
        int[] a = {7, 9, 9, 9, 10, 10, 10, 10, 11};
        System.out.println(removeElement(a,7));
    }
}
