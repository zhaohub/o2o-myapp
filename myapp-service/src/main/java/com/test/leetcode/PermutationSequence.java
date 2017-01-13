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

    public static String getPermutation0(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        int[] fac = new int[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = i * fac[i - 1];
            nums.add(i);
        }
        nums.add(n);
        k = k - 1;
        for (int i = 1; i <= n; i++) {
            int index = k / fac[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * fac[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 14));
        System.out.println(getPermutation0(9, 100000));
    }

}
