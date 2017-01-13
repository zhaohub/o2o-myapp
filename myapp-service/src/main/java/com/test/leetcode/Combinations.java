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
            else if (i == k - 1) res.add(new ArrayList<Integer>(Arrays.asList(p)));
            else {
                ++i;
                p[i] = p[i - 1];
            }
        }
        return res;
    }

    /**
     * backtrace solution
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrace(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    private static void backtrace(List<List<Integer>> res, ArrayList<Integer> temp, int k, int n, int j) {
        if (temp.size() == k)
            res.add(new ArrayList<Integer>(temp));
        else {
            for (int i = j; i <= n; i++) {
                temp.add(i);
                backtrace(res, temp, k, n, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine1(4, 2);
        List<List<Integer>> res1 = combine1(4, 2);
    }
}
