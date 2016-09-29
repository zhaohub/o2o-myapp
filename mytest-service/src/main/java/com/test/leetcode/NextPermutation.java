package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/29.
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int index = nums.length - 1;
        while (nums[index - 1] >= nums[index] && index >= 1)
            --index;

        if (index == 1) {
            Arrays.sort(nums);  //sort asc
            return;
        }

        int first = index - 1, second = index, i = nums.length - 1;
        do {
            if (nums[i] > nums[first]) {
                //swap
                int tmp = nums[first];
                nums[first] = nums[i];
                nums[i] = tmp;
                break;
            }
        } while (--i > 0);
        //sort second to length -1 asc
        Arrays.sort(nums, second, nums.length);
    }

    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int o : array)
            sb.append(" " + o);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 8, 7, 5, 1};
        for (int i = 0; i < 1000; i++) {
            nextPermutation(array);
            printArray(array);
        }

    }

}
