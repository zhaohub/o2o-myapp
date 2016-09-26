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

    public static int divide2(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException("divied by zero");

        if (dividend == 0) return 0;
        if (Math.abs(dividend) < Math.abs(divisor)) return 0;
        boolean sign = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            sign = true;

        long dividendTmp = Math.abs(dividend);
        long divisorTmp = Math.abs(divisor);

        long c = 1;
        while (dividendTmp > divisorTmp) {
            divisorTmp = divisorTmp << 1;
            c = c << 1;
        }

        int res = 0;
        while (dividendTmp >= Math.abs(divisor)) {
            while (dividendTmp >= divisorTmp) {
                dividendTmp -= divisorTmp;
                res += c;
            }
            divisorTmp = divisorTmp >> 1;
            c = c >> 1;
        }
        return sign ? res : -res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(divide(1523535523, 1));
        System.out.println("time1:" + (System.currentTimeMillis() - start));
        long end = System.currentTimeMillis();
        System.out.println(divide2(1523535523, 1));
        System.out.println("time2:" + (System.currentTimeMillis() - end));
    }
}
