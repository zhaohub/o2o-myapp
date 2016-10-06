package com.test.algorithm;

import com.test.leetcode.ValidSudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/6.
 */
public class FindAllSudoku {
    private static char[][] board = new char[10][10];

    private static long count = 0;

    public static void solve(List<char[][]> res, int i, int j) {
        if (i <= 8 && j <= 8) {
            for (char c = '1'; c <= '9'; c++) {
                if (check(board, i, j, c)) {
                    board[i][j] = c;
                    int t = j;
                    if (++t > 8)
                        solve(res, i + 1, 0);
                    else
                        solve(res, i, t);
                    board[i][j] = '0';
                }
            }
        } else {
            //valid
            if (ValidSudoku.isValidSudoku(board))
                count++;
        }
    }

    private static boolean check(char[][] board, int i, int j, char c) {
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c)
                return false;
        }
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c)
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == c)
                    return false;
            }
        }
        return true;
    }


    public static List<char[][]> findAllSudoku() {
        List<char[][]> res = new ArrayList<char[][]>();
        solve(res, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        List<char[][]> res = findAllSudoku();
        System.out.println("sudoku count:" + count);
    }

    private static void printSudoku(char[][] board) {
        System.out.println("solution " + count++ + ",valid:" + ValidSudoku.isValidSudoku(board));
        for (int r = 0; r < board.length; ++r) {
            StringBuilder s = new StringBuilder();
            for (int c = 0; c < board[0].length; ++c) {
                s.append(board[r][c] + " ");
            }
            System.out.println(s.toString());
        }
    }

}
