package com.math.data.stack;

import java.util.Objects;

public class ArrayStack implements Stack {
    private final Object[] data;
    private int count;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack capacity cannot be negative or zero: " + capacity);
        }

        this.data = new Object[capacity];
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == data.length;
    }

    @Override
    public void push(Object o) throws StackOverflowException {
        Objects.requireNonNull(o);

        if (isFull()) {
            throw new StackOverflowException(this);
        }

        data[count] = o;
        count++;
    }

    @Override
    public Object pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException(this);
        }

        --count;
        return data[count];
    }

    @Override
    public Object top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException(this);
        }

        return data[count - 1];
    }
}
