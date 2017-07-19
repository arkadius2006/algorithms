package com.math.data.stack;

public interface StackFactory {

    Stack newStack();

    Stack newStack(int capacity);
}
