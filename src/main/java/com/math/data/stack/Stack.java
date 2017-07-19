package com.math.data.stack;

public interface Stack {

    boolean isEmpty();

    boolean isFull();

    void push(Object o) throws StackOverflowException;

    Object pop() throws StackUnderflowException;

    Object top() throws StackUnderflowException;
}
