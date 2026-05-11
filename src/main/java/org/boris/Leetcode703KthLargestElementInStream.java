package org.boris;

import java.util.PriorityQueue;

public class Leetcode703KthLargestElementInStream {
    private final PriorityQueue<Integer> priorityQueue;
    private final int k;

    public Leetcode703KthLargestElementInStream(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
