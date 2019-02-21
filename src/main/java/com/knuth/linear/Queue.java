package com.knuth.linear;

/**
 * A queue is a linear list for which all insertions are made at one end of the list; all deletions (and accesses)
 * are made from the other end.
 * <p/>
 * With queues we speak of the front and the rear of the queue, also known as head and tail. Things enter at the rear,
 * and ultimatelly are removed when they reach the front position.
 * <p/>
 * Queues feature the so called first-in-first-out "FIFO" behavior.
 */
public interface Queue {

    boolean isEmpty();

    boolean isFull();

    void enqueue(Object o) throws OverflowException;

    Object dequeue() throws UnderflowException;

    Object peek() throws UnderflowException;
}
