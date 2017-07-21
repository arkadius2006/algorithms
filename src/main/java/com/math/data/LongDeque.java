package com.math.data;

public interface LongDeque {

    boolean isEmpty();

    boolean isFull();

    void enqueueLeft(long l) throws OverflowException;

    long dequeueLeft() throws UnderflowException;

    long peekLeft() throws UnderflowException;

    void enqueueRight(long l) throws OverflowException;

    long dequeueRight() throws UnderflowException;

    long peekRight() throws UnderflowException;
}
