package com.test.leetcode;

import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/10/18.
 */
public class LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();

        int n = heights.length, i = 0, maxArea = 0;
        while (i < n) {
            if (stack.empty() || heights[i] >= heights[stack.peek()])
                stack.push(i);
            else {
                while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                    int top = stack.pop();
                    int area = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
                    maxArea = maxArea > area ? maxArea : area;
                }
                stack.push(i);
            }
            i++;
        }

        while (!stack.empty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }


    /**
     * perfect version
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();

        int n = heights.length, i = 0, maxArea = 0;
        while (i < n) {
            if (stack.empty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                int top = stack.pop();
                int area = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!stack.empty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3, 4, 6, 6, 2, 1};
        int[] h1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea1(heights));
    }
}
