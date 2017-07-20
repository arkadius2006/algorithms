package com.math.data;

/**
 * A stack is a linear list for which all insertions and deletions (and accesses) are made at one end of the list.
 * <p/>
 * We put item onto top of a stack, or take the top item off. The bottom of the stack is the least accessible item,
 * and it will not be removed until all other items have been deleted.
 * <p/>
 * Stack features the so called last-in-first-out ("LIFO") behaviour.
 */
public interface Stack {

    boolean isEmpty();

    boolean isFull();

    void push(Object o) throws OverflowException;

    Object pop() throws UnderflowException;

    Object top() throws UnderflowException;
}
