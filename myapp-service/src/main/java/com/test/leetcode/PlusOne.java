package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/10/28.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];
        int c = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = (digits[i] + c) % 10;
            c = (digits[i] + c) / 10;
        }
        if (c == 0)
            return res;

        int[] newNum = new int[n + 1];
        newNum[0] = 1;
        return newNum;
    }

    public static int[] plusOne0(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return Arrays.copyOf(digits, n);
            }
            digits[i] = 0;
        }

        int[] newNum = new int[n + 1];
        newNum[0] = 1;
        return newNum;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int[] res = plusOne(digits);
        int[] res1 = plusOne0(digits);
    }

}
