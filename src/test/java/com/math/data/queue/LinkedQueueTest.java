package com.math.data.queue;

import com.math.data.UnderflowException;
import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {

    @Test
    public void empty() {
        Queue queue = new LinkedQueue();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueueDequeue() {
        Queue queue = new LinkedQueue();
        queue.enqueue("1");
        Assert.assertFalse(queue.isEmpty());

        Object dequeued = queue.dequeue();
        Assert.assertEquals("1", dequeued);
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueuePeek() {
        Queue queue = new LinkedQueue();
        queue.enqueue("1");
        Assert.assertFalse(queue.isEmpty());

        Object peeked = queue.peek();
        Assert.assertEquals("1", peeked);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test(expected = UnderflowException.class)
    public void underflowDequeue() {
        Queue queue = new LinkedQueue();
        queue.dequeue();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeek() {
        Queue queue = new LinkedQueue();
        queue.peek();
    }

    @Test
    public void fifo() {
        Queue queue = new LinkedQueue();

        Assert.assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            Object o = queue.dequeue();
            Assert.assertEquals(i, o);
        }

        Assert.assertTrue(queue.isEmpty());
    }
}
