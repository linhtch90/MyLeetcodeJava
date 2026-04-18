package org.boris;

import java.util.ArrayList;
import java.util.List;

public class Leetcode115MinStack {
    private final List<int[]> stack;
    private int minValue = Integer.MAX_VALUE;

    public Leetcode115MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.size() > 0) {
            minValue = stack.getLast()[1];
        }
        minValue = Math.min(minValue, val);
        stack.add(new int[]{val, minValue});
    }

    public void pop() {
        stack.removeLast();
        if (stack.size() == 0) {
            minValue = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.getLast()[0];
    }

    public int getMin() {
        return stack.getLast()[1];
    }
}
