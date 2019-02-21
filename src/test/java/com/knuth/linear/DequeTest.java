package com.knuth.linear;

import com.knuth.linear.Deque;
import com.knuth.linear.UnderflowException;
import com.knuth.linear.linked.LinkedDeque;
import com.knuth.linear.sequential.ArrayDeque;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DequeTest {

    public static final int N = 10;

    @Parameters(name = "{0}")
    public static Object[] deques() {
        return new Object[]{new ArrayDeque(N), new LinkedDeque()};
    }

    @Parameter
    public Deque deque;

    @Test(expected = UnderflowException.class)
    public void underflowDequeueLeft() {
        deque.dequeueLeft();
    }

    @Test(expected = UnderflowException.class)
    public void underflowDequeueRight() {
        deque.dequeueRight();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeekLeft() {
        deque.peekLeft();
    }

    @Test(expected = UnderflowException.class)
    public void underflowPeekRight() {
        deque.peekRight();
    }

    @Test
    public void leftInleftOutOrder() {
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < N; i++) {
            deque.enqueueLeft(i);
        }

        // LIFO logic
        Assert.assertEquals(N - 1, deque.peekLeft());

        for (int i = N - 1; i >= 0; i--) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void leftInRightOutOrder() {
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i <= N - 1; i++) {
            deque.enqueueLeft(i);
        }

        // FIFO logic
        Assert.assertEquals(0, deque.peekRight());

        for (int i = 0; i < N; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void rightInLeftOutOrder() {
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < N; i++) {
            deque.enqueueRight(i);
        }

        // FIFO logic
        Assert.assertEquals(0, deque.peekLeft());

        for (int i = 0; i < N; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void rightInRightOut() {
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < N; i++) {
            deque.enqueueRight(i);
        }

        // LIFO logic
        Assert.assertEquals(N - 1, deque.peekRight());

        for (int i = N - 1; i >= 0; i--) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void wrapTwiceRightwards() {
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < N; i++) {
            deque.enqueueRight(i);
        }

        for (int i = 0; i < N; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());

        // second cycle

        for (int i = N; i < 2 * N; i++) {
            deque.enqueueRight(i);
        }

        for (int i = N; i < 2 * N; i++) {
            Assert.assertEquals(i, deque.dequeueLeft());
        }

        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void wrapTwiceLeftwards() {
        Assert.assertTrue(deque.isEmpty());

        for (int i = 0; i < N; i++) {
            deque.enqueueLeft(i);
        }

        for (int i = 0; i < N; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());

        // second cycle

        for (int i = N; i < 2 * N; i++) {
            deque.enqueueLeft(i);
        }

        for (int i = N; i < 2 * N; i++) {
            Assert.assertEquals(i, deque.dequeueRight());
        }

        Assert.assertTrue(deque.isEmpty());
    }
}
