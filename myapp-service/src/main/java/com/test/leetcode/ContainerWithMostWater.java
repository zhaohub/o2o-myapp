package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/20.
 */
public class ContainerWithMostWater {

    /**
     * O(n2)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length < 2)
            return maxArea;

        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                int tmpArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = tmpArea > maxArea ? tmpArea : maxArea;
            }
        }
        return maxArea;
    }

    public static int maxArea1(int[] height) {
        int maxArea = 0;
        if (height == null || height.length < 2)
            return maxArea;

        int len = height.length - 1;

        for (int i = 0, j = len; i < j; ) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                while (height[i] < height[++i])
                    break;
            } else {
                while (height[--j] > height[j])
                    break;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {10, 30, 100, 40, 30, 400, 10, 10000};
        System.out.println(maxArea(height));
        System.out.println(maxArea1(height));
    }

}
