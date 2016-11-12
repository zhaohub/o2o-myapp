package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/11.
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n], right = new int[n], height = new int[n];

        int maxA = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(curLeft, left[j]);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }
        }

        return maxA;
    }


    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }

}
