package com.math.data.queue;

public class QueueUnderflowException extends RuntimeException {
    private final Queue queue;

    public QueueUnderflowException(Queue queue) {
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
