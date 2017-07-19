package com.math.data.stack;

public class StackOverflowException extends RuntimeException {
    private final Stack stack;

    public StackOverflowException(Stack stack) {
        this.stack = stack;
    }

    public Stack getStack() {
        return stack;
    }

    @Override
    public String toString() {
        return "Stack overlow: " + stack;
    }
}
