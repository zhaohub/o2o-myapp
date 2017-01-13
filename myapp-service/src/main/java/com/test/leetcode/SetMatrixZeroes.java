package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/11/2.
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list = new ArrayList<int[]>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int[] temp = {i, j};
                    list.add(temp);
                }
            }
        }

        for (int[] a : list) {
            for (int t = 0; t < n; t++)
                matrix[a[0]][t] = 0;

            for (int t = 0; t < m; t++)
                matrix[t][a[1]] = 0;
        }
    }


    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0)
                matrix[i][0] = 0;
        }
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 0, 5, 1},
                {2, 2, 1, 2, 2},
                {2, 3, 4, 5, 6}
        };

        setZeroes1(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
