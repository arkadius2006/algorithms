package com.math.data.queue;

import java.util.Objects;

public class LinkedQueue implements Queue {
    private Node tail; // .headOfTailQueue == null
    private Node head; // .tailOfHeadQueue == null


    public LinkedQueue() {
        this.tail = null;
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueue(Object o) throws QueueOverflowException {
        Objects.requireNonNull(o);

        Node newTail = new Node();
        newTail.data = o;

        if (tail != null) {
            newTail.tailOfHeadQueue = tail;
            tail.headOfTailQueue = newTail;
            tail = newTail;
        } else {
            head = tail = newTail;
        }
    }

    @Override
    public Object dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException(this);
        }

        Object dequeued = head.data;

        head = head.headOfTailQueue;
        if (head != null) {
            head.tailOfHeadQueue = null;
        } else {
            tail = null;
        }


        return dequeued;
    }

    @Override
    public Object peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException(this);
        }

        return head.data;
    }

    private class Node {
        Object data;
        Node tailOfHeadQueue;
        Node headOfTailQueue;
    }
}
