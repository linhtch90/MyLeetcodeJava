package org.boris;

import org.boris.models.ListNode;

public class Leetcode21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode head = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.val = list1.val;
                list1 = list1.next;
            } else {
                result.val = list2.val;
                list2 = list2.next;
            }
            result.next = new ListNode();
            result = result.next;
        }
        while (list1 != null) {
            result.val = list1.val;
            list1 = list1.next;
            if (list1 != null) {
                result.next = new ListNode();
                result = result.next;
            }
        }
        while (list2 != null) {
            result.val = list2.val;
            list2 = list2.next;
            if (list2 != null) {
                result.next = new ListNode();
                result = result.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoListsBetter(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode tail = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        return result.next;
    }
}
