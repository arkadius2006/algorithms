package com.math.data.impl;

import com.math.data.OverflowException;
import com.math.data.Queue;
import com.math.data.UnderflowException;

import java.util.Objects;

class ArrayQueue implements Queue {
    private final int capacity;
    private final Object[] data;
    private int front;
    private int rear;
    private int n;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue capacity cannot be negative or zero");
        }

        this.capacity = capacity;
        this.data = new Object[capacity];
        this.front = 0;
        this.rear = 0;
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

        data[rear] = o;
        rear = IntUtils.inc(rear, capacity);
        n++;
    }

    @Override
    public Object dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Object dequeued = data[front];
        front = IntUtils.inc(front, capacity);
        n--;
        return dequeued;
    }

    @Override
    public Object peek() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        return data[front];
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
