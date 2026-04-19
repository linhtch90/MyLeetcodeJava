package org.boris;

import java.util.Stack;

public class Leetcode84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int heightsLength = heights.length;
        int maxArea = 0;
        for (int i = 0; i <= heightsLength; i++) {
            int currentHeight = (i == heightsLength) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
