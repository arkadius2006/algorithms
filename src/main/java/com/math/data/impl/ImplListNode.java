package com.math.data.impl;

import com.math.data.HeadListNode;
import com.math.data.ListException;
import com.math.data.ListNode;
import com.math.data.StaleNodeListException;

abstract class ImplListNode implements ListNode {
    protected ImplListNode nextNode;
    protected ImplListNode prevNode;
    private boolean isStale;

    ImplListNode() {
        this.nextNode = this;
        this.prevNode = this;
        this.isStale = false;
    }

    @Override
    public boolean isListTrivial() {
        checkStale();
        return this.nextNode == this;
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
    public void insertNext(Object data) {
        checkStale();

        ImplListNode a = new ImplDataListNode(data);
        ImplListNode b = this.nextNode;
        a.nextNode = b;
        this.nextNode = a;
        b.prevNode = a;
        a.prevNode = this;
    }

    @Override
    public void insertPrev(Object data) {
        checkStale();
        ImplListNode a = new ImplDataListNode(data);
        ImplListNode b = this.prevNode;
        a.prevNode = b;
        this.prevNode = a;
        a.nextNode = this;
        b.nextNode = a;
    }

    @Override
    public void removeNext() {
        checkStale();

        ImplListNode a = this.nextNode;
        if (a == this) {
            throw new ListException(this, "List is empty");
        }

        if (a instanceof HeadListNode) {
            throw new ListException(this, "Cannot remove next node since it's head");
        }

        ImplListNode b = a.nextNode;
        this.nextNode = b;
        b.prevNode = this;

        a.markStale();
    }

    @Override
    public void removePrev() {
        checkStale();

        ImplListNode a = this.prevNode;
        if (a == this) {
            throw new ListException(this, "List is empty");
        }

        if (a instanceof HeadListNode) {
            throw new ListException(this, "Cannot delete prev node since it's head");
        }

        ImplListNode b = a.prevNode;
        this.prevNode = b;
        b.nextNode = this;

        a.markStale();
    }

    private void markStale() {
        this.isStale = true;
        this.nextNode = null;
        this.prevNode = null;
    }

    protected void checkStale() {
        if (isStale) {
            throw new StaleNodeListException(this);
        }
    }
}
