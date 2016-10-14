package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/12.
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*')
                dp[s.length()][i] = true;
            else
                break;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*')
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[j][i + 1];
                else
                    dp[i + 1][j + 1] = false;
            }
        }

        return dp[s.length()][p.length()];
    }

    /**
     * better solution,easy understand
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        int sp = 0, pp = 0, match = 0, startId = -1;
        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                startId = pp;
                match = sp;
                pp++;
            } else if (startId != -1) {
                pp = startId + 1;   //recover pp pointer
                match++;
                sp = match;
            } else
                return false;
        }

        while (pp < p.length() && p.charAt(pp) == '*')
            pp++;

        return pp == p.length();
    }

    public static void main(String[] args) {
        //System.out.println(isMatch("aeuwyetur", "?*uuu"));
        //System.out.println(isMatch("abmdddnc", "ab*c"));
        System.out.println(isMatch2("abmdddncqqqqq", "ab*cq***"));
    }
}
