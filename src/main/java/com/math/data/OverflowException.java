package com.math.data;

public class OverflowException extends RuntimeException {
    private final Object container;

    public OverflowException(Object container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Overlow: " + container;
    }
}
