package org.boris;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Leetcode76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int left = 0;
        int start = 0;
        int valid = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char i : t.toCharArray()) {
            need.merge(i, 1, Integer::sum);
        }
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (need.containsKey(currentChar)) {
                window.merge(currentChar, 1, Integer::sum);
                if (Objects.equals(window.get(currentChar), need.get(currentChar))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if ((right - left + 1) < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                char checkChar = s.charAt(left);
                if (need.containsKey(checkChar)) {
                    if (Objects.equals(window.get(checkChar), need.get(checkChar))) {
                        valid--;
                    }
                    window.merge(checkChar, -1, Integer::sum);
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
