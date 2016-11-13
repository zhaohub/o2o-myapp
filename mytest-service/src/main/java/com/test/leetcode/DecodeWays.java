package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        char p = s.charAt(0);
        int i = 1, count = 1;
        while (i < s.length()) {
            char cur = s.charAt(i);
            int t = Character.digit(p, 10) * 10 + Character.digit(cur, 10);
            if (t <= 26)
                count++;
            i++;
            p = cur;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12294"));
    }
}
