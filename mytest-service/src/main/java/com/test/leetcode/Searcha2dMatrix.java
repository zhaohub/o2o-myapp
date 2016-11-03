package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/3.
 */
public class Searcha2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int l = 0, h = matrix.length - 1, line;
        if (target < matrix[0][0])
            return false;
        else if (target >= matrix[0][0] && target <= matrix[h][0]) {
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (target > matrix[mid][0])
                    l = mid + 1;
                else if (target < matrix[mid][0])
                    h = mid - 1;
                else
                    return true;
            }
        }
        line = h;
        l = 0;
        h = matrix[0].length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (target > matrix[line][mid])
                l = mid + 1;
            else if (target < matrix[line][mid])
                h = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {51, 53, 55, 60}
        };

        System.out.println(searchMatrix(matrix, 12));
    }
}
