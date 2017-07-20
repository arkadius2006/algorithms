package com.math.data.stack;

import com.math.data.OverflowException;
import com.math.data.Stack;
import com.math.data.UnderflowException;
import com.math.data.impl.ArrayStack;
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

    @Test(expected = UnderflowException.class)
    public void underflowPop() {
        Stack stack = new ArrayStack(1);
        stack.pop();
    }

    @Test(expected = UnderflowException.class)
    public void underflowTop() {
        Stack stack = new ArrayStack(1);
        stack.top();
    }

    @Test(expected = OverflowException.class)
    public void overflow() {
        Stack stack = new ArrayStack(1);
        stack.push("1");
        stack.push("2");
    }

    @Test
    public void lifo() {
        Stack stack = new ArrayStack(10);
        Assert.assertTrue(stack.isEmpty());

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        Assert.assertTrue(stack.isFull());

        // LIFO logic
        Assert.assertEquals(9, stack.top());

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, stack.pop());
        }

        Assert.assertTrue(stack.isEmpty());
    }
}
