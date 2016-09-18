package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/17.
 */
public class LongestPalindromicSubstring {

    /**
     * 这个方法和第二题的解法类似
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        String rs = "";
        int[] c = new int[128];
        Arrays.fill(c, -1);

        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            if (c[ci] != -1) {
                String sub = s.substring(c[ci], i + 1);
                if (isPalindrome(sub) && sub.length() > rs.length())
                    rs = sub;
            }
            c[ci] = i;
        }
        return rs;
    }


    /**
     * 判断一个字符串是不是回文
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;

        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaab3abcdcbabbduy";
        System.out.println(longestPalindrome(s));
    }
}
