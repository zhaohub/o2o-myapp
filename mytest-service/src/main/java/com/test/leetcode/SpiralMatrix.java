package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/22.
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int[][] direction = {
                {0, 1},     //move right
                {1, 0},     //down
                {0, -1},    //left
                {-1, 0}     //up
        };

        int x = 0, y = 0, c = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0, j = 0; ; i++, j++) {
            if (j / 4 > c) {
                c = j / 4;
                x = c;
                y = c;
            }
            i = i % 4;
            while (res.size() != matrix.length * matrix[0].length) {
                if (i == 0 && y >= matrix[x].length - c - 1) {
                    y = matrix[x].length - c - 1;
                    break;
                }
                if (i == 1 && x >= matrix.length - c - 1) {
                    x = matrix.length - c - 1;
                    break;
                }
                if (i == 2 && y == c) break;
                if (i == 3 && x == c) break;

                res.add(matrix[x][y]);
                x += direction[i][0];
                y += direction[i][1];
            }

            if (res.size() == matrix.length * matrix[0].length)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7},
                {21, 22, 23, 24, 25, 26, 27},
                {31, 32, 33, 34, 35, 36, 37},
                {41, 42, 43, 44, 45, 46, 46},
                {51, 52, 53, 54, 55, 56, 57}
        };

        int[][] ma = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };

        int[][] mb = {{1, 2, 3, 4, 5}};

        List<Integer> res = spiralOrder(ma);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
