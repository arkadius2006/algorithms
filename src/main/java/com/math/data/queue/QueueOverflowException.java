package com.math.data.queue;

public class QueueOverflowException extends RuntimeException {
    private final Queue queue;

    public QueueOverflowException(Queue queue) {
        this.queue = queue;
    }

    public Queue getQueue() {
        return queue;
    }

    @Override
    public String toString() {
        return "Queue overflow: " + queue;
    }
}
