package com.math.data.stack;

import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void emptyStack() {
        Stack stack = new LinkedStack();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void pushPop() {
        Stack stack = new LinkedStack();
        stack.push("1");
        Object popped = stack.pop();
        Assert.assertEquals("1", popped);
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void pushTop() {
        Stack stack = new LinkedStack();
        stack.push("1");
        Object topped = stack.top();
        Assert.assertEquals("1", topped);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test(expected = StackUnderflowException.class)
    public void underflowPop() {
        Stack stack = new LinkedStack();
        stack.pop();
    }

    @Test(expected = StackUnderflowException.class)
    public void underflowTop() {
        Stack stack = new LinkedStack();
        stack.top();
    }
}