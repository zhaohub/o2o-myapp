package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/27.
 */
public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] direction = {
                {0, 1},  //move right
                {1, 0}   //move down
        };

        int x = 1, y = 1;
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuilder().append("(1,1)"), direction, x, y, obstacleGrid);

        for (String s : res) {
            System.out.println(s);
        }

        return res.size();
    }

    private static void dfs(List<String> res, StringBuilder path, int[][] direction, int x, int y, int[][] obstacleGrid) {
        if (x == obstacleGrid.length && y == obstacleGrid[0].length) {
            res.add(path.toString());
        } else
            for (int i = 0; i < direction.length; i++) {
                if (x > obstacleGrid.length || y > obstacleGrid[0].length || obstacleGrid[x - 1][y - 1] == 1) continue;
                x += direction[i][0];
                y += direction[i][1];

                path.append("(").append(x).append(",").append(y).append(")");
                dfs(res, path, direction, x, y, obstacleGrid);

                x -= direction[i][0];
                y -= direction[i][1];
                path.delete(path.lastIndexOf("("), path.length());
            }
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                map[i][0] = 1;
            else
                break;

        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0)
                map[0][j] = 1;
            else
                break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    map[i][j] = 0;
                else
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println(uniquePathsWithObstacles2(grid));
    }

}
