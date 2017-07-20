package com.math.data.stack;

import com.math.data.OverflowException;
import com.math.data.UnderflowException;

import java.util.Objects;

public class ArrayStack implements Stack {
    private final Object[] data;
    private int count; // todo this is called stack pointer, TOP

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
    public void push(Object o) throws OverflowException {
        Objects.requireNonNull(o);

        if (isFull()) {
            throw new OverflowException(this);
        }

        data[count] = o;
        count++;
    }

    @Override
    public Object pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        --count;
        return data[count];
    }

    @Override
    public Object top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        return data[count - 1];
    }
}
