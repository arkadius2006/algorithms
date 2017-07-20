package com.math.data.impl;

import com.math.data.Stack;
import com.math.data.StackFactory;

public class CommonStackFactory implements StackFactory {
    
    @Override
    public Stack newStack() {
        return new LinkedStack();
    }

    @Override
    public Stack newStack(int capacity) {
        return new ArrayStack(capacity);
    }
}
