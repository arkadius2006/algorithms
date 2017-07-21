package com.math.data;

public interface ByteStack {

    boolean isEmpty();

    boolean isFull();

    void push(byte b) throws OverflowException;

    byte pop() throws UnderflowException;

    byte top() throws UnderflowException;
}
