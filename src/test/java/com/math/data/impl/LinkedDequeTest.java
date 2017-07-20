package com.math.data.impl;

import com.math.data.Deque;
import com.math.data.OverflowException;
import com.math.data.UnderflowException;
import org.junit.Assert;
import org.junit.Test;

public class LinkedDequeTest {

    @Test(expected = UnderflowException.class)
    public void underflowDequeueLeft() {
        Deque deque = new LinkedDeque();
        deque.dequeueLeft();
    }

    @Test(expected = UnderflowException.class)
    public void underflowDequeueRight() {
        Deque deque = new LinkedDeque();
        deque.dequeueRight();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeekLeft() {
        Deque deque = new LinkedDeque();
        deque.peekLeft();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeekRight() {
        Deque deque = new LinkedDeque();
        deque.peekRight();
    }

    @Test
    public void leftInleftOutOrder() {
        Deque deque = new LinkedDeque();
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueLeft(i);
        }

        // LIFO logic
        Assert.assertEquals(9, deque.peekLeft());

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void leftInRightOutOrder() {
        Deque deque = new LinkedDeque();
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueLeft(i);
        }

        // FIFO logic
        Assert.assertEquals(0, deque.peekRight());

        for (int i = 0; i <= 9; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void rightInLeftOutOrder() {
        Deque deque = new LinkedDeque();
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueRight(i);
        }

        // FIFO logic
        Assert.assertEquals(0, deque.peekLeft());

        for (int i = 0; i <= 9; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void rightInRightOut() {
        Deque deque = new LinkedDeque();
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueRight(i);
        }

        // LIFO logic
        Assert.assertEquals(9, deque.peekRight());

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void wrapTwiceRightwards() {
        Deque deque = new LinkedDeque();
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.enqueueRight(i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());

        // second cycle

        for (int i = 0; i < 10; i++) {
            deque.enqueueRight(i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void wrapTwiceLeftwards() {
        Deque deque = new LinkedDeque();
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.enqueueLeft(i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());

        // second cycle

        for (int i = 10; i < 20; i++) {
            deque.enqueueLeft(i);
        }

        for (int i = 10; i < 20; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

}
