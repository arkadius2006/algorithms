package com.math.data.impl;

import com.knuth.OverflowException;
import com.math.data.Queue;
import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeCapacity() {
        new ArrayQueue(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroCapacity() {
        new ArrayQueue(0);
    }

    @Test(expected = OverflowException.class)
    public void enqueue() {
        Queue queue = new ArrayQueue(1);
        queue.enqueue("1");
        queue.enqueue("2");
    }

    @Test
    public void wrapTwice() {
        Queue queue = new ArrayQueue(10);

        Assert.assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        Assert.assertTrue(queue.isFull());

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }

        Assert.assertTrue(queue.isEmpty());

        // second cycle

        for (int i = 10; i < 20; i++) {
            queue.enqueue(i);
        }

        Assert.assertTrue(queue.isFull());

        for (int i = 10; i < 20; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }

        Assert.assertTrue(queue.isEmpty());
    }
}
