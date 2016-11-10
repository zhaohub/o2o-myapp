package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/10.
 */
public class SearchinRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target < nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target > nums[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3};
        System.out.println(search(nums, 0));
    }

}
