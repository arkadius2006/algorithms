package com.math.data;

public interface Queue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(Object o) throws OverflowException;

    Object dequeue() throws UnderflowException;

    Object peek() throws UnderflowException;
}
