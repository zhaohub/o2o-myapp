package com.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogang3 on 2016/11/7.
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                return "";
        }

        int start = 0, end = 0, minStart = 0, minEnd = Integer.MAX_VALUE, counter = t.length();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.get(c) > 0)
                counter--;
            map.put(c, map.get(c) - 1);

            end++;

            while (counter == 0) { //find a substring
                if (minEnd - minStart > end - start) {
                    minEnd = end;
                    minStart = start;
                }

                char cc = s.charAt(start);
                map.put(cc, map.get(cc) + 1);

                if (map.get(cc) > 0)
                    counter++;

                start++;
            }
        }

        return minEnd == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
