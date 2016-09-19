package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/19.
 */
public class PalindromeNumber {

    /**
     * 评论区中的解法
     * r的位数最多比循环后的x多一位
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int r = 0;
        while (x > r) {
            x = x / 10;
            r = r * 10 + x % 10;
        }
        return x == r || x == r / 10;
    }

    public static void main(String[] args) {
        int x = 12344321;
        System.out.println(isPalindrome(x));
    }

}
