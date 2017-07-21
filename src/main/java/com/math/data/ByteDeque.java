package com.math.data;

public interface ByteDeque {

    boolean isEmpty();

    boolean isFull();

    void enqueueLeft(byte b) throws OverflowException;

    byte dequeueLeft() throws UnderflowException;

    byte peekLeft() throws UnderflowException;

    void enqueueRight(byte b) throws OverflowException;

    byte dequeueRight() throws UnderflowException;

    byte peekRight() throws UnderflowException;
}
