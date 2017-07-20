package com.math.data.deque;

public interface Deque {

    boolean isEmpty();

    boolean isFull();

    void enqueueHead(Object o);

    Object dequeueHead();

    Object peekHead();

    void enqueueTail(Object o);

    Object dequeueTail();

    Object peekTail();
}
