package com.math.data.stack;

import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeCapacity() {
        new ArrayStack(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroCapacity() {
        new ArrayStack(0);
    }


    @Test
    public void emptyStack() {
        Stack stack = new ArrayStack(1);
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void fullStack() {
        Stack stack = new ArrayStack(1);
        stack.push("1");
        Assert.assertTrue(stack.isFull());
    }

    @Test
    public void pushPop() {
        Stack stack = new ArrayStack(1);
        stack.push("1");
        Object popped = stack.pop();
        Assert.assertEquals("1", popped);
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void pushTop() {
        Stack stack = new ArrayStack(1);
        stack.push("1");
        Object ontop = stack.top();
        Assert.assertEquals("1", ontop);
        Assert.assertTrue(stack.isFull());
        Assert.assertTrue(!stack.isEmpty());
    }

    @Test(expected = StackUnderflowException.class)
    public void underflow() {
        Stack stack = new ArrayStack(1);
        stack.pop();
    }

    @Test(expected = StackOverflowException.class)
    public void overflow() {
        Stack stack = new ArrayStack(1);
        stack.push("1");
        stack.push("2");
    }
}
