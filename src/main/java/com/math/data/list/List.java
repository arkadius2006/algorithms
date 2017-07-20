package com.math.data.list;

public interface List {


    // general query operations

    boolean isEmpty();

    int size();


    // first query/modification operations

    Object getFirst() throws EmptyListException; // peek

    void addFirst(Object newFirst); // enqueue

    void removeFirst() throws EmptyListException; // dequeue

    // todo consider reduce number of operations, e.g. remove returns value etc


    // last query modificaton operations

    Object getLast() throws EmptyListException;

    void addLast(Object newLast);

    void removeLast() throws EmptyListException;


    // todo add vs offer (push, enqueue)

    // todo remove vs poll (pop, dequeue)

    // todo get vs peek
}
