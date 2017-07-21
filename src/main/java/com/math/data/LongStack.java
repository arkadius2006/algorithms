package com.math.data;

public interface LongStack {
    boolean isEmpty();

    boolean isFull();

    void push(long l) throws OverflowException;

    long pop() throws UnderflowException;

    long top() throws UnderflowException;
}
