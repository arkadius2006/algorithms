package com.knuth;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.Parameter;


@RunWith(Parameterized.class)
public class QueueTest {

    public final static int N = 10;

    @Parameterized.Parameters(name = "{0}")
    public static Object[] queues() {
        return new Object[]{
                new ArrayQueue(N),
                new LinkedQueue()
        };
    }

    @Parameter
    public Queue queue;

    @Test
    public void empty() {
        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = UnderflowException.class)
    public void underflowDequeue() {
        queue.dequeue();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeek() {
        queue.peek();
    }

    @Test
    public void fifo() {
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        // FIFO logic
        Assert.assertEquals(0, queue.peek());

        for (int i = 0; i < N; i++) {
            Assert.assertEquals(i, queue.dequeue());
        }
    }

}
