package com.math.data;

public interface List {

    boolean isEmpty();

    Object getFirst() throws EmptyListException;

    void addFirst();

    void removeFirst() throws EmptyListException;

    Object getLast() throws EmptyListException;

    void addLast();

    void removeLast() throws EmptyListException;

    Object reduce(ListReduceOperation op);
}
