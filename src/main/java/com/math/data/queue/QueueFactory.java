package com.math.data.queue;

public interface QueueFactory {

    Queue newQueue();

    Queue newQueue(int capacity);
}
