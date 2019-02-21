package com.knuth;

import org.junit.Test;


public class ArrayDequeTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeCapacity() {
        new ArrayDeque(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroCapacity() {
        new ArrayDeque(0);
    }

    @Test(expected = OverflowException.class)
    public void overflowEnqueueLeft() {
        Deque deque = new ArrayDeque(1);
        deque.enqueueLeft("1");
        deque.enqueueLeft("2");
    }

    @Test(expected = OverflowException.class)
    public void overflowEnqueueRight() {
        Deque deque = new ArrayDeque(1);
        deque.enqueueRight("1");
        deque.enqueueRight("2");
    }
}
