package com.math.data.impl;

import com.math.data.EmptyListException;
import com.math.data.HeadContainsNoDataListException;
import com.math.data.ListNode;
import com.math.data.StaleNodeException;

import java.util.Objects;

class LinkedListNode implements ListNode {
    private boolean isHead;
    private Object data;
    private LinkedListNode nextNode;
    private LinkedListNode prevNode;
    private boolean isStale;

    static LinkedListNode newHeadListNode() {
        LinkedListNode node = new LinkedListNode();
        node.isHead = true;
        node.isStale = false;
        node.nextNode = node;
        node.prevNode = node;
        return node;
    }

    private static LinkedListNode newDataNode(Object o) {
        Objects.requireNonNull(o);

        LinkedListNode node = new LinkedListNode();
        node.data = o;
        node.isHead = false;
        node.isStale = false;
        return node;
    }

    @Override
    public boolean isHeadNode() {
        checkStale();
        return isHead;
    }

    @Override
    public boolean isDataNode() {
        checkStale();
        return !isHeadNode();
    }

    @Override
    public boolean isCircle() {
        checkStale();
        return this.nextNode == this;
    }

    @Override
    public Object get() {
        checkStale();
        if (isHeadNode()) {
            throw new HeadContainsNoDataListException();
        } else {
            return data;
        }
    }

    @Override
    public ListNode next() {
        checkStale();
        return nextNode;
    }

    @Override
    public ListNode prev() {
        checkStale();
        return prevNode;
    }

    @Override
    public void set(Object o) {
        checkStale();
        Objects.requireNonNull(o);

        if (isHeadNode()) {
            throw new HeadContainsNoDataListException();
        } else {
            this.data = o;
        }
    }

    @Override
    public void insertNext(Object o) {
        checkStale();
        LinkedListNode a = newDataNode(o);
        LinkedListNode b = this.nextNode;
        a.nextNode = b;
        this.nextNode = a;
        b.prevNode = a;
        a.prevNode = this;
    }

    @Override
    public void insertPrev(Object o) {
        checkStale();
        LinkedListNode a = newDataNode(o);
        LinkedListNode b = this.prevNode;
        a.prevNode = b;
        this.prevNode = a;
        a.nextNode = this;
        b.nextNode = a;
    }

    @Override
    public void removeNext() {
        checkStale();
        LinkedListNode a = this.nextNode;
        if (a == this) {
            throw new EmptyListException();
        }

        LinkedListNode b = a.nextNode;
        this.nextNode = b;
        b.prevNode = this;

        a.markStale();
    }

    @Override
    public void removePrev() {
        checkStale();
        LinkedListNode a = this.prevNode;
        if (a == this) {
            throw new EmptyListException();
        }

        LinkedListNode b = a.prevNode;
        this.prevNode = b;
        b.nextNode = this;

        a.markStale();
    }

    private void markStale() {
        this.isStale = true;
        this.nextNode = null;
        this.prevNode = null;
    }

    private void checkStale() {
        if (isStale) {
            throw new StaleNodeException();
        }
    }
}
