package com.math.data;

public interface IntStack {

    boolean isEmpty();

    boolean isFull();

    void push(int i) throws OverflowException;

    int pop() throws UnderflowException;

    int top() throws UnderflowException;
}
