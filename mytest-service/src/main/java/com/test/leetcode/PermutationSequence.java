package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/26.
 */
public class PermutationSequence {

    /**
     * 找出所有的排列，取出第k个
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        if (n < 1 || n > 9) return "";
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuffer(), new boolean[11], n, 1);
        return res.get(k - 1);
    }

    static void dfs(List<String> res, StringBuffer s, boolean[] used, int n, int i) {
        if (s.length() == n)
            res.add(s.toString());
        else
            for (int j = 1; j <= n; j++) {
                if (used[j]) continue;
                used[j] = true;
                s.append(j);
                dfs(res, s, used, n, i + 1);
                s.deleteCharAt(s.length() - 1);
                used[j] = false;
            }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 24));
    }

}
