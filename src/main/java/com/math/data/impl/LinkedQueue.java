package com.math.data.impl;

import com.math.data.Queue;
import com.math.data.UnderflowException;

import java.util.Objects;

/**
 * D. Knuth. Art of Computer Programming, Vol 1: Section 2.2.4. Circular Lists.
 */
class LinkedQueue implements Queue {
    private Node rear;

    public LinkedQueue() {
        rear = null;
    }

    @Override
    public boolean isEmpty() {
        return rear == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueue(Object o) {
        Objects.requireNonNull(o);

        Node a = new Node();
        a.data = o;

        if (isEmpty()) {
            rear = a;
            rear.next = rear;
        } else {
            Node front = rear.next; // this is the key idea of this data structure: list is curcular

            rear.next = a;
            a.next = front;
            rear = a;
        }
    }

    @Override
    public Object dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Node front = rear.next; // again, this is the key idea of this data structure: list is curcular

        if (front == rear) {
            rear = null;
        } else {
            rear.next = front.next;
        }

        return front.data;
    }

    @Override
    public Object peek() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Node front = rear.next;

        return front.data;
    }

    private static class Node {
        Object data;
        Node next; // node that's closer to the rear, or the front if this is the rear (curcular list structure)
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
