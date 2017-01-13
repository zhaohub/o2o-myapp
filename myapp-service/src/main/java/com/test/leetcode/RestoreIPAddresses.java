package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/15.
 */
public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return null;
        List<String> res = new ArrayList<String>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        if (a + b + c + d == s.length()) {
                            int p1 = Integer.parseInt(s.substring(0, a));
                            int p2 = Integer.parseInt(s.substring(a, a + b));
                            int p3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int p4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                            if (p1 <= 255 && p2 <= 255 && p3 <= 255 && p4 <= 255)
                                res.add(p1 + "." + p2 + "." + p3 + "." + p4);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = restoreIpAddresses("2202222543");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
