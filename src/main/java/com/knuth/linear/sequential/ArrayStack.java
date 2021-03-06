package com.knuth.linear.sequential;

import com.knuth.linear.OverflowException;
import com.knuth.linear.Stack;
import com.knuth.linear.UnderflowException;

import java.util.Objects;

/**
 * D. Knuth. Art of Computer Programming, Vol 1: Section 2.2.2. Sequential Allocations.
 */
public class ArrayStack implements Stack {
    private final Object[] data;
    private int top;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack capacity cannot be negative or zero: " + capacity);
        }

        this.data = new Object[capacity];
        this.top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == data.length;
    }

    @Override
    public void push(Object o) throws OverflowException {
        if (isFull()) {
            throw new OverflowException(this);
        }

        data[top] = o;
        top++;
    }

    @Override
    public Object pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        --top;
        return data[top];
    }

    @Override
    public Object top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        return data[top - 1];
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
