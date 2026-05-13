package org.boris;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : freq) {
            if (i > 0) {
                maxHeap.offer(i);
            }
        }
        // Queue item typing [remainingCount, timeAvailable]
        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldownQueue.offer(new int[]{remaining, time + n + 1});
                }
            }
        }
        return time;
    }
}
