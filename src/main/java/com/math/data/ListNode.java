package com.math.data;

/**
 * All interface method could throw {@link com.math.data.StaleNodeListException}.
 */
public interface ListNode {

    boolean isHeadNode();

    boolean isDataNode();

    boolean isListEmpty();

    Object get() throws HeadContainsNoDataListException;

    ListNode next();

    ListNode prev();

    void set(Object o) throws HeadContainsNoDataListException;

    void insertNext(Object o);

    void insertPrev(Object o);

    void removeNext() throws EmptyListException;

    void removePrev() throws EmptyListException;
}
