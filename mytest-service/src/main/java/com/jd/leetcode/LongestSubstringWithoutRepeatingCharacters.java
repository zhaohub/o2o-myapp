package com.jd.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "cdefghefxdzmcqrht";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int i = 0, max = 0, sub = 0, lastRepeat = 0;
        int[] chars = new int[128];
        Arrays.fill(chars, -1);
        while (i < s.length()) {
            char c = s.charAt(i);
            int repeat = chars[c];
            if (repeat > -1) {
                lastRepeat = repeat > lastRepeat ? repeat : lastRepeat;
                max = Math.max(i - lastRepeat, max);
            } else {
                sub = i - lastRepeat;
            }
            max = Math.max(sub, max);
            chars[c] = i++;
        }
        return max;
    }
}
