package com.problems;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        // sentinel node, serves as head of chain
        ListNode head = new ListNode(0);

        // a points to the A tail: remaining node that has not been linked to result yet
        // b points to the B tail

        // points to the last node of result chain
        ListNode c = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }

            c = c.next;
        }

        // either A or B is exhausted..

        // link A-tail to the end of result list
        if (a != null) {
            c.next = a;
        }

        // link B-tail to the end of result list
        if (b != null) {
            c.next = b;
        }

        return head.next; // sentinel node is not needed anymore
    }

}
