package com.math.data.impl;

import com.math.data.OverflowException;
import com.math.data.Stack;
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

    @Test(expected = OverflowException.class)
    public void overflow() {
        Stack stack = new ArrayStack(1);
        stack.push("1");
        stack.push("2");
    }
}
