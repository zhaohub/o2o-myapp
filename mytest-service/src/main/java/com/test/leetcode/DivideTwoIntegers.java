package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/26.
 */
public class DivideTwoIntegers {

    /**
     * log(n)
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException("divied by zero");

        if (dividend == 0) return 0;
        if (Math.abs(dividend) < Math.abs(divisor)) return 0;
        boolean sign = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            sign = true;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int i = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            i++;
        }
        return sign ? i : -i;
    }

    public static void main(String[] args) {
        System.out.println(divide(-10, 3));
        System.out.println(-10 / 3);
    }
}
