package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/7.
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int i = 0;
        Integer[] p = new Integer[k];
        Arrays.fill(p, 0);
        while (i >= 0) {
            p[i]++;
            if (p[i] > n) --i;
            else if (i == k - 1) res.add(Arrays.asList(p));
            else {
                ++i;
                p[i] = p[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
    }
}
