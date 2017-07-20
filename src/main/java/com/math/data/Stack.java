package com.math.data;

import com.math.data.OverflowException;
import com.math.data.UnderflowException;

public interface Stack {

    boolean isEmpty();

    boolean isFull();

    void push(Object o) throws OverflowException;

    Object pop() throws UnderflowException;

    Object top() throws UnderflowException;
}
