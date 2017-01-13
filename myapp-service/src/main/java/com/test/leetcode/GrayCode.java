package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class GrayCode {

    public static List<Integer> grayCode(int n) {
        int count = (int) Math.pow(2, n);
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = grayCode(4);
        System.out.println(Arrays.toString(res.toArray()));
    }

}
