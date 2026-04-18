package org.boris;

import java.util.Stack;

public class Leetcode739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int peekIndex = stack.pop();
                result[peekIndex] = i - peekIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
