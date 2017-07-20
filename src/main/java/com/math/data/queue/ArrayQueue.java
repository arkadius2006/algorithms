package com.math.data.queue;

import com.math.data.OverflowException;
import com.math.data.UnderflowException;

import java.util.Objects;

public class ArrayQueue implements Queue {
    private final int capacity;
    private final Object[] data;
    private int head; // todo front
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
    public void enqueue(Object o) throws OverflowException {
        Objects.requireNonNull(o);

        if (isFull()) {
            throw new OverflowException(this);
        }

        int index = cap(head + n);
        data[index] = o;
        n++;
    }

    @Override
    public Object dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Object dequeued = data[head];
        head = cap(head + 1);
        n--;
        return dequeued;
    }

    @Override
    public Object peek() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        return data[head];
    }

    private int cap(int index) {
        return index % capacity;
    }
}
