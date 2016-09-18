package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/17.
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;

        String[] result = new String[numRows];
        Arrays.fill(result, "");

        int row = 0, direction = 1;
        for (int i = 0; i < s.length(); i++) {
            if (row == 0)
                direction = 1;
            if (row == numRows - 1)
                direction = -1;

            result[row] += s.charAt(i);
            row += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (String r : result)
            sb.append(r);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }

}
