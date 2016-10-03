package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/3.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid]) {
                start = mid + 1;
                if (start <= nums.length - 1 && target < nums[start])
                    return start;
            } else {
                end = mid - 1;
                if (end >= 0 && target > nums[end])
                    return mid;
            }
        }
        return target < nums[0] ? 0 : nums.length;
    }

    /**
     * better solution
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid])
                return mid;
            if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert1(nums, 2));
    }
}
