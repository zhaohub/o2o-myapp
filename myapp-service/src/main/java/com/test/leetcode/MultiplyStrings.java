package com.test.leetcode;

import java.math.BigInteger;

/**
 * Created by zhaogang3 on 2016/10/11.
 */
public class MultiplyStrings {

    /**
     * O(n2)
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        int[] res = new int[num1.length() + num2.length()];     //multiply result

        for (int i = 0; i < num1.length(); i++)
            n1[i] = Character.digit(num1.charAt(i), 10);

        for (int j = 0; j < num2.length(); j++)
            n2[j] = Character.digit(num2.charAt(j), 10);

        for (int j = n2.length - 1; j >= 0; j--) {
            for (int i = n1.length - 1; i >= 0; i--) {
                int b = res.length - 2 - i - j;
                int t = res[b] + n1[i] * n2[j];
                if (t >= 10 && b < res.length - 1) {
                    res[b + 1] += t / 10;
                }
                res[b] = t % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = res.length - 1; k >= 0; k--) {
            sb.append(res[k]);
        }
        String str = sb.toString();
        while (str.startsWith("0"))
            str = str.substring(1);
        return str;
    }

    public static void main(String[] args) {
        String s1 = "999999990000876492792423947293473820840238430000009999999999999999999";
        String s2 = "10000190279342394732300000000";
        System.out.println(multiply(s1, s2));
        System.out.println(new BigInteger(s1).multiply(new BigInteger(s2)));
    }
}
