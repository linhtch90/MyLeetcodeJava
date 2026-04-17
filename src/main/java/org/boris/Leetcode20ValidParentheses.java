package org.boris;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode20ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> charStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                charStack.push(')');
            } else if (currentChar == '[') {
                charStack.push(']');
            } else if (currentChar == '{') {
                charStack.push('}');
            } else if (charStack.isEmpty() || charStack.pop() != currentChar) {
                return false;
            }
        }
        return charStack.isEmpty();
    }
}
