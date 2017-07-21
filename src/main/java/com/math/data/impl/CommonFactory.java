package com.math.data.impl;

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
    public ListNode newHeadListNode() {
        return LinkedListNode.newHeadListNode();
    }

    @Override
    public ByteStack newByteStack(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStack newIntStack(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongStack newLongStack(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ByteQueue newByteQueue(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntQueue newIntQueue(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongQueue newLongQueue(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ByteDeque newByteDeque(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntDeque newIntDeque(int capacity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongDeque newLongDeque(int capacity) {
        throw new UnsupportedOperationException();
    }
}
