package com.math.data.deque;

import com.math.data.OverflowException;
import com.math.data.UnderflowException;
import org.junit.Assert;
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

    @Test(expected = UnderflowException.class)
    public void underflowDequeueLeft() {
        Deque deque = new ArrayDeque(1);
        deque.dequeueLeft();
    }

    @Test(expected = UnderflowException.class)
    public void underflowDequeueRight() {
        Deque deque = new ArrayDeque(1);
        deque.dequeueRight();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeekLeft() {
        Deque deque = new ArrayDeque(1);
        deque.peekLeft();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeekRight() {
        Deque deque = new ArrayDeque(1);
        deque.peekRight();
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

    @Test
    public void leftInleftOutOrder() {
        Deque deque = new ArrayDeque(10);
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueLeft(i);
        }

        Assert.assertTrue(deque.isFull());

        // LIFO logic
        Assert.assertEquals(9, deque.peekLeft());

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void leftInRightOutOrder() {
        Deque deque = new ArrayDeque(10);
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueLeft(i);
        }

        Assert.assertTrue(deque.isFull());

        // FIFO logic
        Assert.assertEquals(0, deque.peekRight());

        for (int i = 0; i <= 9; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void rightInLeftOutOrder() {
        Deque deque = new ArrayDeque(10);
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueRight(i);
        }

        Assert.assertTrue(deque.isFull());

        // FIFO logic
        Assert.assertEquals(0, deque.peekLeft());

        for (int i = 0; i <= 9; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void rightInRightOut() {
        Deque deque = new ArrayDeque(10);
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= 9; i++) {
            deque.enqueueRight(i);
        }

        Assert.assertTrue(deque.isFull());

        // LIFO logic
        Assert.assertEquals(9, deque.peekRight());

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void wrapTwiceRightwards() {
        Deque deque = new ArrayDeque(10);
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.enqueueRight(i);
        }

        Assert.assertTrue(deque.isFull());

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());

        // second cycle

        for (int i = 0; i < 10; i++) {
            deque.enqueueRight(i);
        }

        Assert.assertTrue(deque.isFull());

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void wrapTwiceLeftwards() {
        Deque deque = new ArrayDeque(10);
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.enqueueLeft(i);
        }

        Assert.assertTrue(deque.isFull());

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());

        // second cycle

        for (int i = 10; i < 20; i++) {
            deque.enqueueLeft(i);
        }

        Assert.assertTrue(deque.isFull());

        for (int i = 10; i < 20; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }
}
