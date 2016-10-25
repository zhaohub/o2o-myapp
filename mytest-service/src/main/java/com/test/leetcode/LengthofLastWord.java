package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/25.
 */
public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                len++;
            else
                break;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
