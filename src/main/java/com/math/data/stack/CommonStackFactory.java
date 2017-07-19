package com.math.data.stack;

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
