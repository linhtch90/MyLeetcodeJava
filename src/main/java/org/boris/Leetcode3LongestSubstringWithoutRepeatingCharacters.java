package org.boris;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> visitedMap = new HashMap<>();
        int leftIndex = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (visitedMap.containsKey(currentChar)) {
                leftIndex = Math.max(leftIndex, visitedMap.get(currentChar) + 1);
            }
            visitedMap.put(currentChar, i);
            result = Math.max(result, i - leftIndex + 1);
        }

        return result;
    }
}
