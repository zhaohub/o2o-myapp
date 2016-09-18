package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/17.
 */
public class StringtoInteger {


    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        boolean negative = false;
        char sign = str.charAt(0);

        if (sign == '-') {
            negative = true;
            str = str.substring(1, str.length());
        } else if (sign == '+') {
            negative = false;
            str = str.substring(1, str.length());
        }

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 48;
            if (c > 10 || c < 0)
                throw new NumberFormatException("For input string " + str);
            result = result * 10 + c;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                throw new NumberFormatException("For input string" + str);
        }
        return negative ? -result : result;
    }


    public static void main(String[] args) {
        String s = "892343";
        System.out.println(myAtoi(s));
    }

}
