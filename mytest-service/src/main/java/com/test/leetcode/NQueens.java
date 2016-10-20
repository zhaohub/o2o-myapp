package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/20.
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        if (n < 4) return null;

        boolean[][] matrix = new boolean[n + 1][n + 1];
        List<List<String>> res = new ArrayList<List<String>>();
        trial(res, matrix, 1);
        return res;
    }

    public static void trial(List<List<String>> res, boolean[][] matrix, int i) {
        int n = matrix.length - 1;
        if (i > n) {
            List<String> ls = new ArrayList<String>();
            for (int k = 1; k <= n; k++) {
                StringBuilder sb = new StringBuilder();
                for (int l = 1; l <= n; l++) {
                    if (matrix[k][l])
                        sb.append("Q ");
                    else
                        sb.append("+ ");
                }
                ls.add(sb.toString());
            }
            res.add(ls);
        } else
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = true;
                if (isLeagal(matrix, i, j)) {
                    trial(res, matrix, i + 1);
                }
                matrix[i][j] = false;
            }
    }

    private static boolean isLeagal(boolean[][] matrix, int i, int j) {
        for (int m = 1; m <= i - 1; m++) {
            for (int n = 1; n <= matrix.length - 1; n++) {
                if (matrix[m][n])
                    if (n == j || Math.abs(i - m) == Math.abs(j - n))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(8);

        for (int i = 0; i < res.size(); i++) {
            System.out.println("solution " + (i + 1));
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }
}
