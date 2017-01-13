package com.test.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/17.
 */
public class Equation {

    public static List<String> solve(int[] nums) {
        int[] book = new int[10];
        List<String> res = new ArrayList<String>();
        dfs(res, new ArrayList<Integer>(), nums, 0, book);
        return res;
    }

    private static void dfs(List<String> res, List<Integer> temp, int[] nums, int start, int[] book) {
        if (temp.size() == 9 && (temp.get(0) * 100 + temp.get(1) * 10 + temp.get(2) + temp.get(3) * 100 + temp.get(4) * 10 + temp.get(5)
                == temp.get(6) * 100 + temp.get(7) * 10 + temp.get(8))) {
            res.add(temp.get(0).toString() + temp.get(1).toString() + temp.get(2).toString() + " + " +
                    temp.get(3).toString() + temp.get(4).toString() + temp.get(5).toString() + " = " +
                    temp.get(6).toString() + temp.get(7).toString() + temp.get(8).toString());
            return;
        } else
            for (int i = 0; i < nums.length; i++) {
                if (book[nums[i]] == 0) {
                    temp.add(nums[i]);
                    book[nums[i]] = 1;
                    dfs(res, temp, nums, start + 1, book);
                    book[nums[i]] = 0;
                    temp.remove(temp.size() - 1);
                }
            }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> res = solve(nums);
        System.out.println(res.size() + " solutions");
        for (String s : res) {
            System.out.println(s);
        }
    }

}
