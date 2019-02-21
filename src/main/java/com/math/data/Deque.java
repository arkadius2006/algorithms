package com.math.data;

import com.knuth.OverflowException;
import com.knuth.UnderflowException;

/**
 * Deque is a linear list for which all insertions and deletions (and acceses) are made at the ends of the list.
 * <p/>
 * When referring to deques we speak of the left and the right ends.
 */
public interface Deque {

    boolean isEmpty();

    boolean isFull();

    void enqueueLeft(Object o) throws OverflowException;

    Object dequeueLeft() throws UnderflowException;

    Object peekLeft() throws UnderflowException;

    void enqueueRight(Object o) throws OverflowException;

    Object dequeueRight() throws UnderflowException;

    Object peekRight() throws UnderflowException;
}
