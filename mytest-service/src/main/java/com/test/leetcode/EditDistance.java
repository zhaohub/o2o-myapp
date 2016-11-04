package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/2.
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            dp[i][0] = i;

        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m][n];
    }

    public static int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] col0 = new int[m + 1];
        for (int i = 1; i <= m; i++)
            col0[i] = i;

        for (int j = 1; j <= n; j++) {
            int pre = col0[0];
            col0[0] = j;
            for (int i = 1; i <= m; i++) {
                int t = col0[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    col0[i] = pre;
                else
                    col0[i] = Math.min(pre + 1, Math.min(col0[i] + 1, col0[i - 1] + 1));
                pre = t;
            }
        }
        return col0[m];
    }

    public static void main(String[] args) {
        String word1 = "eeba";
        String word2 = "abca";
        System.out.println(minDistance1(word1, word2));
    }

}