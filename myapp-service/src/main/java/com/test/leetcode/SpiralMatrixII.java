package com.test.leetcode;

import java.util.Arrays;

/**
 * Created by zhaogang3 on 2016/10/25.
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] direction = {
                {0, 1},     //move right
                {1, 0},     //down
                {0, -1},    //left
                {-1, 0}     //up
        };


        int x = 0, y = 0, c = 0, k = 1;
        boolean flag = true;
        int[][] res = new int[n][n];
        for (int i = 0, j = 0; flag; i++, j++) {
            i = i % 4;  //direction
            if (j / 4 > c) {    //circle
                c = j / 4;
                x = y = c;
            }
            while (true) {
                if (i == 0 && y >= n - c - 1) {
                    y = n - c - 1;
                    break;
                }
                if (i == 1 && x >= n - c - 1) {
                    x = n - c - 1;
                    break;
                }
                if ((i == 2 && y == c) || (i == 3 && x == c)) break;

                if (k == n * n) {
                    flag = false;
                    break;
                }
                res[x][y] = k++;
                x += direction[i][0];   //move
                y += direction[i][1];
            }
        }

        if (n % 2 == 0)
            res[n / 2][n / 2 - 1] = n * n;
        else
            res[n / 2][n / 2] = n * n;  //center
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}
