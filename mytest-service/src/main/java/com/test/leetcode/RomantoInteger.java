package com.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaogang3 on 2016/9/20.
 */
public class RomantoInteger {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int romanToInt(String s) {
        int result = 0;
        if (s == null || s.length() == 0)
            return result;

        char pre = s.charAt(0), next;
        result = map.get(pre);
        for (int i = 1; i < s.length(); i++) {
            next = s.charAt(i);
            int p = map.get(pre), n = map.get(next);
            if (p >= n)
                result = result + n;
            else
                result = result + n - 2 * p;
            pre = next;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MDCCCXCIX"));
    }
}
