package org.boris;

public class Leetcode42TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                leftMax = Math.max(leftMax, height[leftIndex]);
                result = result + (leftMax - height[leftIndex]);
                leftIndex++;
            } else {
                rightMax = Math.max(rightMax, height[rightIndex]);
                result = result + (rightMax - height[rightIndex]);
                rightIndex--;
            }
        }

        return result;
    }
}
