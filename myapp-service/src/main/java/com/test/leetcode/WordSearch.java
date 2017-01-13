package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/8.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        boolean[][] mask = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    if (exist(board, i, j, word.toCharArray(), 0, mask))
                        return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int x, int y, char[] chars, int i, boolean[][] mask) {
        if (i == chars.length) return true;
        if (x >= board.length || x < 0) return false;
        if (y >= board[0].length || y < 0) return false;

        if (board[x][y] == chars[i] && !mask[x][y]) {
            mask[x][y] = true;
            if (exist(board, x + 1, y, chars, i + 1, mask)
                    || exist(board, x, y + 1, chars, i + 1, mask)
                    || exist(board, x - 1, y, chars, i + 1, mask)
                    || exist(board, x, y - 1, chars, i + 1, mask))
                return true;
            mask[x][y] = false;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
