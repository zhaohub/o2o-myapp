package com.jd.leetcode;

/**
 * Created by zhaogang3 on 2016/9/17.
 */
public class RemoveDuplicatesfromSortedArray {


    /**
     * 去掉数组中的重复数字
     *
     * @param nums 排好序的数组
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow])
                nums[++slow] = nums[fast];
        }
        return slow + 1;
    }

    /**
     * 保留指定的重复个数
     *
     * @param nums    排好序的数组
     * @param repeatN 要保留的重复的个数，最少保留一个
     * @return
     */
    public static int removeDuplicatesN(int[] nums, int repeatN) {
        if (nums.length < repeatN)
            return nums.length;

        int slow = 0, repeat = 1;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
                repeat = 1;
            } else if (fast != 0 && ++repeat <= repeatN) {
                ++slow;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] a = {7, 9, 9, 9, 10, 10, 10, 10, 11};
        System.out.println(removeDuplicates(a));
        int[] b = {7, 9, 9, 9, 10, 10, 10, 10, 11};
        System.out.println(removeDuplicatesN(b, 2));
    }
}
