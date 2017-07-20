package com.math.data.impl;

import com.math.data.Deque;
import com.math.data.OverflowException;
import com.math.data.UnderflowException;

import java.util.Objects;

public class LinkedDeque implements Deque {
    private final Node head;

    public LinkedDeque() {
        head = new Node();
        head.data = null;
        head.left = head;
        head.right = head;
    }

    @Override
    public boolean isEmpty() {
        return head.right == head;

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueueLeft(Object o) throws OverflowException {
        Objects.requireNonNull(o);

        addRight(head, o);
    }

    @Override
    public Object dequeueLeft() throws UnderflowException {
        return removeRight(head);
    }

    @Override
    public Object peekLeft() throws UnderflowException {
        return getRight(head);
    }

    @Override
    public void enqueueRight(Object o) throws OverflowException {
        Objects.requireNonNull(o);

        addLeft(head, o);
    }

    @Override
    public Object dequeueRight() throws UnderflowException {
        return removeLeft(head);
    }

    @Override
    public Object peekRight() throws UnderflowException {
        return getLeft(head);
    }


    private void addRight(Node n, Object o) {
        Node a = new Node();
        a.data = o;

        Node b = n.right;

        n.right = a;
        a.right = b;

        b.left = a;
        a.left = n;
    }

    private void addLeft(Node n, Object o) {
        Node a = new Node();
        a.data = o;

        Node b = n.left;

        n.left = a;
        a.left = b;

        b.right = a;
        a.right = n;
    }

    private Object removeRight(Node n) {
        Node a = n.right;
        if (a == n) {
            throw new UnderflowException(this);
        }

        Node b = a.right;

        n.right = b;
        b.left = n;

        return a.data;

    }

    private Object removeLeft(Node n) {
        Node a = n.left;

        if (a == n) {
            throw new UnderflowException(this);
        }

        Node b = a.left;

        n.left = b;
        b.right = n;

        return a.data;
    }

    private Object getRight(Node n) {
        Node a = n.right;

        if (a == n) {
            throw new UnderflowException(this);
        }

        return a.data;
    }

    private Object getLeft(Node n) {
        Node a = n.left;

        if (a == n) {
            throw new UnderflowException(this);
        }

        return a.data;
    }

    private class Node {
        Node left;
        Node right;
        Object data;
    }
}
