package com.problems;

/**
 * Given singly linked list find whether is has cycle. The cycle
 * could start from any position, not necessary from 0th.
 */
public class LinkedListCycle {

    static class Node {
        Node next;
    }

    public boolean hasLoop(Node head) {
        Node a = head;
        Node b = head;

        while (a != null && b != null) {
            a = a.next;
            b = b.next;
            if (b == null) {
                return false;
            }
            b = b.next;

            if (a == b) {
                return true;
            }
        }
        do {
            a = move(a, 1);
            b = move(b, 2);
        }  while (a != null && b != null && a != b);

        return a != null && b != null;
    }

    private Node move(Node a, int k) {
        while (a != null && k > 0) {
            a = a.next;
            k--;
        }

        return a;
    }
}
