package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/28.
 */
public class AddBinary {


    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        int an = a.length(), bn = b.length();
        int t = an - bn;
        boolean c = false;
        String res = "";
        for (int i = an - 1; i >= t; i--) {
            if (a.charAt(i) == '1' && b.charAt(i - t) == '1') {
                res = (c ? "1" : "0") + res;
                c = true;
            } else if (a.charAt(i) == '0' && b.charAt(i - t) == '0') {
                res = (c ? "1" : "0") + res;
                c = false;
            } else {
                res = (c ? "0" : "1") + res;
            }
        }

        if (c) {
            String tmp = "";
            for (int i = t - 1; i >= 0; i--) {
                if (a.charAt(i) == '0') {
                    tmp = "1" + tmp;
                    return a.substring(0, i) + tmp + res;
                }
                tmp = "0" + tmp;
            }
            return "1" + tmp + res;
        }
        return a.substring(0, t) + res;
    }

    public static void main(String[] args) {
        String b = "1011011011";
        String a = "1000010";
        System.out.println(addBinary(a, b));
    }
}
