package org.boris;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode295FindMedianFromDataStream {
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public Leetcode295FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
