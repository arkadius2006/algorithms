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

        // FIFO logic
        Assert.assertEquals(0, queue.peek());

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }

        Assert.assertTrue(queue.isEmpty());
    }
}
