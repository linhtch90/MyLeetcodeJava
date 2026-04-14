package org.boris;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Leetcode424LongestRepeatingCharacterReplacement {
    // Not efficient
    public int characterReplacementNotEfficient(String s, int k) {
        int result = 0;
        int leftIndex = 0;
        Map<Character, Integer> frequentMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            frequentMap.merge(currentChar, 1, (oldValue, _) -> oldValue + 1);
            int maxVal = Collections.max(frequentMap.values());
            while ((i - leftIndex + 1 - maxVal) > k) {
                char tempChar = s.charAt(leftIndex);
                int currentFrequent = frequentMap.get(tempChar);
                frequentMap.put(tempChar, currentFrequent - 1);
                leftIndex++;
            }
            result = Math.max(result, i - leftIndex + 1);
        }
        return result;
    }

    // Efficient
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFreq = 0, result = 0;
        for (int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);
            // Shrink if more than k replacements needed
            while (right - left + 1 - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
