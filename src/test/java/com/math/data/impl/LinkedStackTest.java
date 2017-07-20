package com.math.data.impl;

import com.math.data.Stack;
import com.math.data.UnderflowException;
import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void emptyStack() {
        Stack stack = new LinkedStack();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = UnderflowException.class)
    public void underflowPop() {
        Stack stack = new LinkedStack();
        stack.pop();
    }

    @Test(expected = UnderflowException.class)
    public void underflowTop() {
        Stack stack = new LinkedStack();
        stack.top();
    }

    @Test
    public void lifo() {
        Stack stack = new LinkedStack();
        Assert.assertTrue(stack.isEmpty());

        for (int i = 0; i <= 9; i++) {
            stack.push(i);
        }

        // LIFO logic
        Assert.assertEquals(9, stack.top());
        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, stack.pop());
        }

        Assert.assertTrue(stack.isEmpty());
    }
}
