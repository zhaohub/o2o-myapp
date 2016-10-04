package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/10/4.
 */
public class CountandSay {
    public static String countAndSay(int n) {
        int[] count = new int[10];
        Arrays.fill(count, 1);

        if (n == 1)
            return "1";
        else {
            String prev = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < prev.length(); i++) {
                int d = prev.charAt(i) - 48;
                int last = i + 1 < prev.length() ? prev.charAt(i + 1) - 48 : 0;
                if (d == last) {
                    count[d]++;
                } else {
                    int cn = count[d];
                    sb.append(cn).append(d);
                    count[d] = 1;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }

}
