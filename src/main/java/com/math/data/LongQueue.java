package com.math.data;

public interface LongQueue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(long l) throws OverflowException;

    long dequeue() throws UnderflowException;

    long peek() throws UnderflowException;
}
