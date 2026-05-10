package org.boris;

import org.boris.models.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast.next != null) {
                slow = slow.next;
                if (fast.next.next != null) {
                    fast = fast.next.next;
                } else {
                    return false;
                }
                if (fast == slow) {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public boolean hasCycleBetter(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
