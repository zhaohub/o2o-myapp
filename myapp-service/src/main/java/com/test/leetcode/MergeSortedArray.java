package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n])
                nums1[k--] = nums1[m--];
            else
                nums1[k--] = nums2[n--];
        }
        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[10];
        int[] nums2 = new int[3];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        nums1[3] = 6;

        nums2[0] = -2;
        nums2[1] = 4;
        nums2[2] = 6;

        merge(nums1, 4, nums2, 3);
    }
}
