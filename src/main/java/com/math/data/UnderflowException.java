package com.math.data;

public class UnderflowException extends RuntimeException {
    private final Object container;

    public UnderflowException(Object container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Undeflow: " + container;
    }
}
