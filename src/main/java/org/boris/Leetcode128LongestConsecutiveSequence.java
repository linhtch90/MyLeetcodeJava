package org.boris;

import java.util.HashSet;
import java.util.Set;

public class Leetcode128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visitedSet = new HashSet<>();
        for (int item : nums) {
            visitedSet.add(item);
        }

        int result = 0;
        for (int item : visitedSet) {
            if (!visitedSet.contains(item - 1)) {
                int length = 1;
                while (visitedSet.contains(item + length)) {
                    length++;
                }
                result = Math.max(result, length);
            }
        }

        return result;
    }
}
