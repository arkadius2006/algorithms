package com.math.data;

public interface IntDeque {

    boolean isEmpty();

    boolean isFull();

    void enqueueLeft(int i) throws OverflowException;

    int dequeueLeft() throws UnderflowException;

    int peekLeft() throws UnderflowException;

    void enqueueRight(int i) throws OverflowException;

    int dequeueRight() throws UnderflowException;

    int peekRight() throws UnderflowException;
}
