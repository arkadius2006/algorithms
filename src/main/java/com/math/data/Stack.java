package com.math.data;

public interface Stack {

    boolean isEmpty();

    Object pop() throws StackUnderflowException;

    Object top() throws StackUnderflowException;

    boolean isFull();

    void push(Object o) throws StackOverflowException;
}
