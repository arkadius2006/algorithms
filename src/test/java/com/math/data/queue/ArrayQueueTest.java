package com.math.data.queue;

import com.math.data.OverflowException;
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
    public void enqueueDequeue() {
        Queue queue = new ArrayQueue(1);
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue("1");
        Assert.assertTrue(queue.isFull());

        Object dequeued = queue.dequeue();
        Assert.assertEquals("1", dequeued);
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueuePeek() {
        Queue queue = new ArrayQueue(1);
        Assert.assertTrue(queue.isEmpty());

        queue.enqueue("1");
        Assert.assertTrue(queue.isFull());

        Object peeked = queue.peek();
        Assert.assertEquals("1", peeked);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test(expected = OverflowException.class)
    public void overflow() {
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
    public void wrapTwoTimes() {
        Queue queue = new ArrayQueue(10);

        Assert.assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        Assert.assertTrue(queue.isFull());

        for (int i = 0; i < 10; i++) {
            Object o = queue.dequeue();
            Assert.assertEquals(i, o);
        }

        Assert.assertTrue(queue.isEmpty());

        // second cycle
        for (int i = 10; i < 20; i++) {
            queue.enqueue(i);
        }

        Assert.assertTrue(queue.isFull());

        for (int i = 10; i < 20; i++) {
            Object o = queue.dequeue();
            Assert.assertEquals(i, o);
        }

        Assert.assertTrue(queue.isEmpty());
    }
}
