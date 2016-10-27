package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/27.
 */
public class UniquePaths {

    private static int paths = 0;

    /**
     * we find all paths
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[][] direction = {
                {0, 1},  //move right
                {1, 0}   //move down
        };

        int x = 1, y = 1;
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuilder().append("(1,1)"), direction, x, y, m, n);

        for (String s : res) {
            System.out.println(s);
        }

        return res.size();
    }

    private static void dfs(List<String> res, StringBuilder path, int[][] direction, int x, int y, int m, int n) {
        if (x == m && y == n) {
            res.add(path.toString());
        } else
            for (int i = 0; i < direction.length; i++) {
                if (x > m || y > n) continue;
                x += direction[i][0];
                y += direction[i][1];

                path.append("(").append(x).append(",").append(y).append(")");
                dfs(res, path, direction, x, y, m, n);

                x -= direction[i][0];
                y -= direction[i][1];
                path.delete(path.lastIndexOf("("), path.length());
            }
    }

    /**
     * perfect solution
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 8));
        System.out.println(uniquePaths2(10, 8));
    }
}
