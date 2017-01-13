package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/31.
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static List<String> climbStairs1(int n) {
        List<String> res = new ArrayList<String>();
        dfs(res, new ArrayList<Integer>(), 1, n);
        return res;
    }

    private static void dfs(List<String> res, List<Integer> temp, int i, int n) {
        int sum = 0;
        for (int t : temp) {
            sum += t;
        }

        if (sum == n)
            res.add(temp.toString());
        else if (sum < n)
            for (int s = 1; s <= 2; s++) {
                temp.add(s);
                dfs(res, temp, i + 1, n);
                temp.remove(temp.size() - 1);
            }
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
        List<String> res = climbStairs1(5);
        for (String s : res) {
            System.out.println(s);
        }
    }


}
