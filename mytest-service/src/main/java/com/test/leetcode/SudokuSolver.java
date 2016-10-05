package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/4.
 */
public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (check(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
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
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        long start = System.currentTimeMillis();
        solveSudoku(board);
        System.out.println("consume time:" + (System.currentTimeMillis() - start));
        for (int row = 0; row < board.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < board[row].length; col++) {
                sb.append(board[row][col] + " ");
            }
            System.out.println(sb.toString());
        }
        //valid sudoku
        System.out.println(ValidSudoku.isValidSudoku(board));
    }
}