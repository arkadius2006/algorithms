package com.math.data.queue;

public interface Queue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(Object o) throws QueueOverflowException;

    Object dequeue() throws QueueUnderflowException;

    Object peek() throws QueueUnderflowException;
}
