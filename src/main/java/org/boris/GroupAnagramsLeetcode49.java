package org.boris;

import java.util.*;

public class GroupAnagramsLeetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> visitedMap = new HashMap<>();
        for (String item : strs) {
            char[] itemChars = item.toCharArray();
            Arrays.sort(itemChars);
            String sorted = new String(itemChars);
            visitedMap.computeIfAbsent(sorted, k -> new ArrayList<>()).add(item);
        }
        return new ArrayList<>(visitedMap.values());
    }
}
