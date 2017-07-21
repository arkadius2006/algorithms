package com.math.data;

public interface ListNode {

    boolean isHeadNode();

    boolean isDataNode();

    boolean isCircle(); // todo think of better name

    Object get();

    ListNode next();

    ListNode prev();

    void set(Object o);

    void insertNext(Object o);

    void insertPrev(Object o);

    void removeNext();

    void removePrev();
}
