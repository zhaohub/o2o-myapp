package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/24.
 */
public class JumpGame {

    /**
     * 遇到0时向后搜索（应该还可以优化）
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        boolean can = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = 0;
                while (i - j > 0) {
                    j++;
                    if (nums[i - j] <= j)
                        can = false;
                    else {
                        can = true;
                        break;
                    }
                }
            }
        }
        return can;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, 1, 1, 4};
        int[] a2 = {5, 0, 1, 0, 4};

        System.out.println(canJump(a1));
        System.out.println(canJump(a2));
    }
}
