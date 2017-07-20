package com.math.data;

public interface Stack {

    boolean isEmpty();

    boolean isFull();

    void push(Object o) throws OverflowException;

    Object pop() throws UnderflowException;

    Object top() throws UnderflowException;
}
