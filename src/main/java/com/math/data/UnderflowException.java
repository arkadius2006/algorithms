package com.math.data;

/**
 * Underflow exception is thrown when one attempts to extract item
 * from empty collection.
 */
public class UnderflowException extends RuntimeException {
    private final Object container;

    public UnderflowException(Object container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Underflow: " + container;
    }
}
