package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/10/15.
 */
public class RotateImage {

    /**
     * n2 space
     *
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        if (matrix == null) return;

        int n = matrix.length;
        int[][] temp = new int[n][n];

        for (int j = 0; j <= n - 1; j++) {
            for (int i = n - 1; i >= 0; i--) {
                temp[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++)
            matrix[i] = temp[i];
    }

    /**
     * clockwise rotate
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        if (matrix == null) return;

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    /**
     * anticlockwise rotate
     *
     * @param matrix
     */
    public static void antiRotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;

        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 7, 3, 2},
                {5, 6, 5, 9},
                {9, 2, 4, 1},
                {8, 6, 0, 2}
        };

        rotate(matrix);
        printMatrix(matrix);
        System.out.println("------------");
        antiRotate(matrix);
        printMatrix(matrix);
    }
}
