package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/12.
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1])
                dp[0][i + 1] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];

                if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j + 1))
                        dp[i + 1][j + 1] = dp[i][j];
                    else
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i - 1][j + 1];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dp[0].length; j++) {
                sb.append(dp[i][j] + " ");
            }
            System.out.println(sb.toString());
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        //System.out.println(isMatch("aeuwyetur", "?*uuu"));
        System.out.println(isMatch("abmnc", "ab*c"));
    }
}
