package com.math.data;

public interface Queue {

    boolean isFull();

    void enqueue(Object o) throws QueueOverflowException;

    boolean isEmpty();

    Object dequeue() throws QueueUnderflowException;

    Object peek() throws QueueUnderflowException;
}
