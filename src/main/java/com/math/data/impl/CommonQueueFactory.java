package com.math.data.impl;

import com.math.data.Queue;
import com.math.data.QueueFactory;

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
