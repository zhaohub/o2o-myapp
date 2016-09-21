package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/20.
 */
public class IntegertoRoman {

    /**
     * I  1
     * V  5
     * X  10
     * L  50
     * C  100
     * D  500
     * M  1000
     */

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999)
            throw new IllegalArgumentException("exceeds max value");

        String c[][] = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};

        StringBuilder roman = new StringBuilder();
        roman.append(c[3][num / 1000]);
        roman.append(c[2][num / 100 % 10]);
        roman.append(c[1][num / 10 % 10]);
        roman.append(c[0][num % 10]);

        return roman.toString();
    }


    public static void main(String[] args){
        System.out.println(intToRoman(1899));
    }
}
