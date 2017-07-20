package com.math.data.impl;

import com.math.data.Stack;
import com.math.data.UnderflowException;

import java.util.Objects;

class LinkedStack implements Stack {
    private Node top;

    public LinkedStack() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(Object o) {
        Objects.requireNonNull(o);

        Node a = new Node();
        a.data = o;

        a.next = top;
        top = a;
    }

    @Override
    public Object pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        Object o = top.data;
        top = top.next;
        return o;
    }

    @Override
    public Object top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException(this);
        }

        return top.data;
    }

    private static class Node {
        Object data;
        Node next; // the node below, or null if this is bottom
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
