package com.test.algorithm;

import com.test.leetcode.ValidSudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/6.
 */
public class FindAllSudoku {

    private static char[][] board = new char[9][9];  //store sudoku

    /**
     * 找出所有数独
     *
     * @return
     */
    public static List<char[][]> findAllSudoku(int n) {
        if (n <= 0) return null;
        List<char[][]> res = new ArrayList<char[][]>();
        solve(res, 0, 0, n);
        return res;
    }

    private static void solve(List<char[][]> res, int i, int j, int num) {
        if (res.size() >= num)   //find num
            return;

        if (i <= 8 && j <= 8) {
            for (char c = '1'; c <= '9'; c++) {
                if (check(board, i, j, c)) {
                    board[i][j] = c;
                    int t = j;
                    if (++t > 8)
                        solve(res, i + 1, 0, num);
                    else
                        solve(res, i, t, num);
                    board[i][j] = '0';
                }
            }
        } else {
            char[][] tempBoard = new char[9][9];
            for (int r = 0; r < board.length; r++) {
                tempBoard[r] = Arrays.copyOf(board[r], board[r].length);
            }
            res.add(tempBoard);      //too more board
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

    public static void main(String[] args) {
        List<char[][]> res = findAllSudoku(100);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("solution " + (i + 1) + ", valid:" + ValidSudoku.isValidSudoku(res.get(i)));
            printSudoku(res.get(i));
        }
    }

    private static void printSudoku(char[][] board) {
        for (int r = 0; r < board.length; ++r) {
            StringBuilder s = new StringBuilder();
            for (int c = 0; c < board[0].length; ++c) {
                s.append(board[r][c]);
                if (c != board[0].length - 1)
                    s.append(" ");
            }
            System.out.println(s.toString());
        }
    }
}
