package com.knuth.linear;

/**
 * Overflow exception is thrown when one attempts to add item to collection
 * which is already full.
 */
public class OverflowException extends RuntimeException {
    private final Object container;

    public OverflowException(Object container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Overflow: " + container;
    }
}
