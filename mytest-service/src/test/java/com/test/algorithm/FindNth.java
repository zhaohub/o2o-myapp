package com.test.algorithm;

/**
 * Created by zhaogang3 on 2016/10/14.
 */
public class FindNth {

    private static long findNth(int n) {
        if (n <= 0)
            return -1;

        long i = 1, num = 0;
        while (true) {
            if (i % 2 == 0 || i % 3 == 0) {
                if (++num == n)
                    break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(findNth(Integer.MAX_VALUE));
    }
}
