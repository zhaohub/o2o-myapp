package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/3.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int[][] rowTimes = new int[10][10];
        int[][] colTimes = new int[10][10];
        int[][] subTimes = new int[10][10];

        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] != '.') {
                    int d = row[j];
                    if (++rowTimes[i][d] > 1 || ++colTimes[j][d] > 1 || ++subTimes[j / 3 + i / 3 * 3][d] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {5, 3, '.', '.', 7, '.', '.', '.', '.'},
                {6, '.', '.', 1, 9, 5, '.', '.', '.'},
                {'.', 9, 8, '.', '.', '.', '.', 6, '.'},
                {8, '.', '.', '.', 6, '.', '.', '.', 3},
                {4, '.', '.', 8, '.', 3, '.', '.', 1},
                {7, '.', '.', '.', 2, '.', '.', '.', 6},
                {'.', 6, '.', '.', '.', '.', 2, 8, '.'},
                {'.', '.', '.', 4, 1, 9, '.', '.', 5},
                {'.', '.', '.', '.', 8, '.', '.', 7, 9}
        };
        System.out.println(isValidSudoku(board));
    }

}
