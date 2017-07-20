package com.math.data.queue;

import com.math.data.OverflowException;
import com.math.data.UnderflowException;

public interface Queue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(Object o) throws OverflowException;

    Object dequeue() throws UnderflowException;

    Object peek() throws UnderflowException;
}
