package org.boris;

public class Leetcode11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            result = Math.max(result, area);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return result;
    }
}
