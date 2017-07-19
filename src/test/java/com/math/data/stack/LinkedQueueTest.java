package com.math.data.stack;

import com.math.data.queue.LinkedQueue;
import com.math.data.queue.Queue;
import com.math.data.queue.QueueUnderflowException;
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

    @Test(expected = QueueUnderflowException.class)
    public void underflowDequeue() {
        Queue queue = new LinkedQueue();
        queue.dequeue();
    }

    @Test(expected = QueueUnderflowException.class)
    public void underflowPeek() {
        Queue queue = new LinkedQueue();
        queue.peek();
    }
}
