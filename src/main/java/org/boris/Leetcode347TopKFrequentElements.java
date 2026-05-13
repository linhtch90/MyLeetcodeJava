package org.boris;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];
        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        maxHeap.addAll(frequentMap.entrySet());
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                results[i] = maxHeap.poll().getKey();
            }
        }
        return results;
    }
}
