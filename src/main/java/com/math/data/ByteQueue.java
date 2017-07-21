package com.math.data;

public interface ByteQueue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(byte b) throws OverflowException;

    byte dequeue() throws UnderflowException;

    byte peek() throws UnderflowException;
}
