package com.math.data;

public interface IntQueue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(int i) throws OverflowException;

    int dequeue() throws UnderflowException;

    int peek() throws UnderflowException;
}
