package org.boris;

import org.boris.models.ListNode;

import java.util.PriorityQueue;

public class Leetcode23MergedKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode i : lists) {
            if (i != null) {
                minHeap.add(i);
            }
        }

        ListNode result = new ListNode(0);
        ListNode current = result;
        while (!minHeap.isEmpty()) {
            ListNode minHeapPoll = minHeap.poll();
            current.next = minHeapPoll;
            current = current.next;
            if (minHeapPoll.next != null) {
                minHeap.add(minHeapPoll.next);
            }
        }

        return result.next;
    }
}
