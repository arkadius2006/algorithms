package com.math.data.impl;

import com.math.data.Deque;
import com.math.data.Factory;
import com.math.data.Queue;
import com.math.data.Stack;

public class CommonFactory implements Factory {

    @Override
    public Stack newStack() {
        return new LinkedStack();
    }

    @Override
    public Stack newStack(int capacity) {
        return new ArrayStack(capacity);
    }

    @Override
    public Queue newQueue() {
        return new LinkedQueue();
    }

    @Override
    public Queue newQueue(int capacity) {
        return new ArrayQueue(capacity);
    }

    @Override
    public Deque newDeque() {
        throw new UnsupportedOperationException(); // todo
    }

    @Override
    public Deque newDeque(int capacity) {
        return new ArrayDeque(capacity);
    }
}
