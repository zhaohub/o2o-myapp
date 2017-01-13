package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/26.
 */
public class ImplementstrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int h = haystack.length(), n = needle.length();
        if (h == 0 || h < n) return -1;
        if (n == 0) return 0;

        for (int i = 0; i < h; i++) {
            int j = 0, index = Integer.MAX_VALUE;
            while (true) {
                if (haystack.charAt(i) == needle.charAt(j++)) { //j moves forward
                    index = Math.min(i++, index);  //i moves forward
                    if (j == needle.length())
                        return index;   //matched
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abcdefgasferqwer", "e43"));
    }
}
