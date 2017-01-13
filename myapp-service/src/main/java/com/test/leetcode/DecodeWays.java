package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = s.charAt(0) != '0' ? 1 : 0;

        int i = 1;
        do {
            if (s.charAt(i) == '0') continue;
            int t = Integer.parseInt(s.substring(i - 1, i + 1));
            if (t <= 26)
                count[i + 1] = count[i] + count[i - 1];
            else
                count[i + 1] = count[i];
        } while (++i < s.length());

        return count[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1229123"));
    }
}
