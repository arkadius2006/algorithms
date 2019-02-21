package com.knuth.linear;

import com.knuth.linear.Stack;
import com.knuth.linear.UnderflowException;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.linear.sequential.ArrayStack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StackTest {
    private final static int N = 10;

    @Parameter
    public Stack stack;

    @Test
    public void emptyStack() {
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = UnderflowException.class)
    public void underflowPop() {
        stack.pop();
    }

    @Test(expected = UnderflowException.class)
    public void underflowTop() {
        stack.top();
    }

    @Test
    public void lifo() {
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }

        // LIFO logic
        Assert.assertEquals(N - 1, stack.top());
        for (int i = N - 1; i >= 0; i--) {
            Assert.assertEquals(i, stack.pop());
        }
    }

    @Parameters(name = "{0}")
    public static Object[] STACKS() {
        return new Object[]{
                new ArrayStack(N),
                new LinkedStack()
        };
    }

}
