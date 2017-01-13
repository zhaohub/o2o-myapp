package com.test.algorithm;

/**
 * Created by zhaogang3 on 2016/10/6.
 */
public class NQueues {

    public static int N = 6;

    private static boolean[][] matrix = new boolean[N + 1][N + 1];

    private static int count = 0;

    private static boolean isLeagal(boolean[][] matrix, int i, int j) {
        for (int m = 1; m <= i - 1; m++) {
            for (int n = 1; n <= N; n++) {
                if (matrix[m][n])
                    if (n == j || Math.abs(i - m) == Math.abs(j - n))
                        return false;
            }
        }
        return true;
    }

    public static void trial(int i) {
        if (i > N)
            printQueues(matrix);
        else
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = true;
                if (isLeagal(matrix, i, j))
                    trial(i + 1);
                matrix[i][j] = false;  //important,force try next queue
            }
    }

    private static void printQueues(boolean[][] matrix) {
        System.out.println("solution " + ++count);
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j])
                    sb.append("Q ");
                else
                    sb.append("+ ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        trial(1);
    }
}
