package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/16.
 */
public class PowXN {

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        int t = 2;
        double tx = x;
        if (n >= 2) {
            while (t <= n) {
                x = x * x;
                t = t << 1;
            }
            x = x * myPow(tx, n - (t >> 1));
        }
        return x;
    }

    public static double myPow2(double x, int n) {
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(5.1, 122));
        System.out.println(myPow2(5.1, 122));
        System.out.print(Math.pow(5.1, 122));
    }
}
