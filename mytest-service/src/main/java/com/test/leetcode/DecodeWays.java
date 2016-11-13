package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char p = s.charAt(0);

        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = Integer.parseInt(s.substring(0, 1)) <= 26 ? 1 : 0;

        int i = 1;
        while (i < s.length()) {
            char cur = s.charAt(i);
            int t = Character.digit(p, 10) * 10 + Character.digit(cur, 10);
            if (t <= 26)
                count[i + 1] = count[i] + count[i - 1];
            else
                count[i + 1] = count[i];
            i++;
            p = cur;
        }
        return count[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1229123"));
    }
}
