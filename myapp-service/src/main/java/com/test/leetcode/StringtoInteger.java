package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/17.
 */
public class StringtoInteger {


    /**
     * 暂不支持空格，输入有误或溢出时抛出NumberFormatException
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null)
            throw new NullPointerException();

        if (str.length() == 0)
            throw new IllegalArgumentException("myAtoi argument wrong for " + str);

        boolean negative = false;
        char sign = str.charAt(0);

        if (sign == '-') {
            negative = true;
            str = str.substring(1, str.length());
        } else if (sign == '+') {
            negative = false;
            str = str.substring(1, str.length());
        }

        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 48;
            if (c > 10 || c < 0)
                throw new NumberFormatException("For input string " + str);
            result = result * 10 + c;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                throw new NumberFormatException("For input string" + str);
        }
        return negative ? -(int) result : (int) result;
    }


    public static void main(String[] args) {
        String s = "-3424";
        System.out.println(myAtoi(s));
    }

}
