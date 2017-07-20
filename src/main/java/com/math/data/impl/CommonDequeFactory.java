package com.math.data.impl;

import com.math.data.Deque;
import com.math.data.DequeFactory;

public class CommonDequeFactory implements DequeFactory {
    @Override
    public Deque newDequeu() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Deque newDequeue(int capacity) {
        return new ArrayDeque(capacity);
    }
}
