package com.jd.leetcode;

/**
 * Created by zhaogang3 on 2016/9/17.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        String s = String.valueOf(x), rev = "";
        for (int i = s.length() - 1; i >= 0; i--)
            rev += s.charAt(i);

        try {
            return positive ? Integer.parseInt(rev) : -Integer.parseInt(rev);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse2(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }

        if(r>=Integer.MIN_VALUE&& r<=Integer.MAX_VALUE)
            return (int) r;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(-1299));
    }

}
