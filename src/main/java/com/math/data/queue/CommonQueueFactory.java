package com.math.data.queue;

public class CommonQueueFactory implements QueueFactory {
    @Override
    public Queue newQueue() {
        return new LinkedQueue();
    }

    @Override
    public Queue newQueue(int capacity) {
        return new ArrayQueue(capacity);
    }
}
