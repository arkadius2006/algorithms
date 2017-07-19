package com.math.data.stack;

public class StackUnderflowException extends RuntimeException {
    private final Stack stack;

    public StackUnderflowException(Stack stack) {
        this.stack = stack;
    }

    public Stack getStack() {
        return stack;
    }

    @Override
    public String toString() {
        return "Stack undeflow: " + stack;
    }
}
