package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/9/21.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c == strs[j].charAt(i) && j == strs.length - 1) {
                    common.append(c);
                } else if (c != strs[j].charAt(i)) {
                    return common.toString();
                }
            }
        }
        return common.toString();
    }

    /**
     * 最优解
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";

        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        int i = 0, len = Math.min(first.length, last.length);
        while (i < len && first[i] == last[i])
            i++;

        return strs[0].substring(0, i);
    }

    /**
     * 与最优解法的思路一致，但代码不够精简
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {

        if (strs == null || strs.length < 2)
            return null;

        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < strs[minIndex].length())
                minIndex = i;

            if (strs[i].length() > strs[maxIndex].length())
                maxIndex = i;
        }

        if (minIndex == maxIndex)
            maxIndex = strs.length - 1;

        StringBuilder common = new StringBuilder();
        for (int i = 0; i < strs[minIndex].length(); i++) {
            char c = strs[maxIndex].charAt(i);
            if (c == strs[minIndex].charAt(i))
                common.append(c);
            else
                break;
        }

        for (int j = 2; j < strs.length; j++) {
            if (!strs[j].startsWith(common.toString()))
                return "";
        }
        return common.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abcd", "az"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix1(strs));
        System.out.println(longestCommonPrefix2(strs));
    }
}