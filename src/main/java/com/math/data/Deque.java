package com.math.data;

public interface Deque {

    boolean isEmpty();

    boolean isFull();

    void enqueueLeft(Object o) throws OverflowException;

    Object dequeueLeft() throws UnderflowException;

    Object peekLeft() throws UnderflowException;

    void enqueueRight(Object o) throws OverflowException;

    Object dequeueRight() throws UnderflowException;

    Object peekRight() throws UnderflowException;
}
