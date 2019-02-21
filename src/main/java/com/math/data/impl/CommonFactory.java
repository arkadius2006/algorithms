package com.math.data.impl;

import com.knuth.ArrayStack;
import com.knuth.LinkedStack;
import com.knuth.Stack;
import com.math.data.*;

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
        return new LinkedDeque();
    }

    @Override
    public Deque newDeque(int capacity) {
        return new ArrayDeque(capacity);
    }

    @Override
    public HeadListNode newHeadListNode() {
        return new ImplHeadListNode();
    }

}
