package com.math.data.queue;

import java.util.Objects;

public class ArrayQueue implements Queue {
    private final int capacity;
    private final Object[] data;
    private int head;
    private int n;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue capacity cannot be negative or zero");
        }

        this.capacity = capacity;
        this.data = new Object[capacity];
        this.head = 0;
        this.n = 0;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public boolean isFull() {
        return n == capacity;
    }

    @Override
    public void enqueue(Object o) throws QueueOverflowException {
        Objects.requireNonNull(o);

        if (isFull()) {
            throw new QueueOverflowException(this);
        }

        int index = cap(head + n);
        data[index] = o;
        n++;
    }

    @Override
    public Object dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException(this);
        }

        Object dequeued = data[head];
        head = cap(head + 1);
        n--;
        return dequeued;
    }

    @Override
    public Object peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException(this);
        }

        return data[head];
    }

    private int cap(int index) {
        return index % capacity;
    }
}
