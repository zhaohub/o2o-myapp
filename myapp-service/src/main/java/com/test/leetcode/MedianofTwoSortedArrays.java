package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/16.
 */
public class MedianofTwoSortedArrays {

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1)
            return findKth(nums1, nums2, total / 2 + 1);
        else
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2;
    }

    /**
     * 寻找第k小的数
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private static double findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findKth(nums2, nums1, k);

        if (m == 0) return nums2[k - 1];

        if (k == 1) return Math.min(nums1[0], nums2[0]);

        int pa = Math.min(k / 2, m), pb = k - pa;
        if (nums1[pa - 1] < nums2[pb - 1])
            return findKth(Arrays.copyOfRange(nums1, pa, m), nums2, k - pa);
        else if (nums1[pa - 1] > nums2[pb - 1])
            return findKth(nums1, Arrays.copyOfRange(nums2, pb, n), k - pb);
        else
            return nums1[pa - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 8, 10, 11, 15};
        int[] nums2 = {9, 12, 14, 16};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
