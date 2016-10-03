package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/3.
 */
public class SearchforaRange {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                result[0] = mid;
                result[1] = mid;

                int tmp = mid;
                while (nums[++tmp] == target) {
                    result[1] = tmp;
                }
                while (nums[--tmp] == target)
                    result[0] = tmp;
                break;
            }
            if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 8, 10};
        int[] res = searchRange(nums, 8);
    }
}
