package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        char[] letters = new char[256];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
            letters[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (letters[i] != 0) return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        String s3 = "rgtae";
        System.out.println(isScramble(s1, s2));
        System.out.println(isScramble(s2, s3));
    }

}
