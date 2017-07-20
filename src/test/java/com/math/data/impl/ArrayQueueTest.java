package com.math.data.impl;

import com.math.data.OverflowException;
import com.math.data.Queue;
import com.math.data.UnderflowException;
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

    @Test
    public void fifo() {
        Queue queue = new ArrayQueue(10);
        Assert.assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        Assert.assertTrue(queue.isFull());

        // FIFO logic
        Assert.assertEquals(0, queue.peek());

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }

        Assert.assertTrue(queue.isEmpty());
    }


    @Test(expected = OverflowException.class)
    public void Enqueue() {
        Queue queue = new ArrayQueue(1);
        queue.enqueue("1");
        queue.enqueue("2");
    }

    @Test(expected = UnderflowException.class)
    public void underflowDequeue() {
        Queue queue = new ArrayQueue(1);
        queue.dequeue();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeek() {
        Queue queue = new ArrayQueue(1);
        queue.peek();
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
