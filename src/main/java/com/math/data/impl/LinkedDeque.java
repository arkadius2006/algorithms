package com.math.data.impl;

import com.math.data.Deque;
import com.math.data.UnderflowException;

import java.util.Objects;

/**
 * D. Knuth. Art of Computer Programming, Vol 1: Section 2.2.5. Doubly Linked Lists.
 */
class LinkedDeque implements Deque {
    private final Node head;

    public LinkedDeque() {
        head = new Node();
        head.data = null;
        head.prev = head;
        head.next = head;
    }

    @Override
    public boolean isEmpty() {
        return head.next == head;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueueLeft(Object o) {
        Objects.requireNonNull(o);

        Node a = new Node();
        a.data = o;

        Node b = head.next;
        head.next = a;
        a.next = b;
        b.prev = a;
        a.prev = head;
    }

    @Override
    public Object dequeueLeft() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Node a = head.next;
        Node b = a.next;
        head.next = b;
        b.prev = head;
        return a.data;
    }

    @Override
    public Object peekLeft() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Node a = head.next;
        return a.data;
    }

    @Override
    public void enqueueRight(Object o) {
        Objects.requireNonNull(o);

        Node a = new Node();
        a.data = o;

        Node b = head.prev;
        head.prev = a;
        a.prev = b;
        b.next = a;
        a.next = head;
    }

    @Override
    public Object dequeueRight() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Node a = head.prev;
        Node b = a.prev;
        head.prev = b;
        b.next = head;
        return a.data;

    }

    @Override
    public Object peekRight() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Node a = head.prev;
        return a.data;
    }

    private static class Node {
        Object data;
        Node prev;
        Node next;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
