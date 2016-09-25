package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/9/25.
 */
public class GenerateParentheses {

    //经典的backtracing问题
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) return null;
        List<String> res = new ArrayList<String>();
        backtrace("", res, n, n);
        return res;
    }

    public static void backtrace(String subStr, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(subStr);        //括号用完时，加入结果，返回
            return;
        }

        if (left > right) return;
        if (left > 0)
            backtrace(subStr + "(", res, left - 1, right);
        if (right > 0)
            backtrace(subStr + ")", res, left, right - 1);
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(7);
        System.out.println(list.size());
        /*for (String s : list) {
            System.out.println(s);
        }*/
    }
}
