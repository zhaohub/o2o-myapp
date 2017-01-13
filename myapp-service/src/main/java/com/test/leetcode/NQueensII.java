package com.test.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaogang3 on 2016/10/20.
 */
public class NQueensII {

    public static int totalNQueens(int n) {
        if (n < 4) return 0;

        Set<Integer> cols = new HashSet<Integer>();
        Set<Integer> d1 = new HashSet<Integer>();
        Set<Integer> d2 = new HashSet<Integer>();
        return backtrace(cols, d1, d2, 0, 0, n);
    }

    private static int backtrace(Set<Integer> cols, Set<Integer> d1, Set<Integer> d2, int count, int row, int n) {
        for (int col = 0; col < n; col++) {
            int t1 = row - col;
            int t2 = row + col;
            if (cols.contains(col) || d1.contains(t1) || d2.contains(t2))
                continue;

            if (row == n - 1)
                count++;
            else {
                cols.add(col);
                d1.add(t1);
                d2.add(t2);
                count = backtrace(cols, d1, d2, count, row + 1, n);
                cols.remove(col);
                d1.remove(t1);
                d2.remove(t2);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }


}
