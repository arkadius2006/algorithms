package com.math.data.packed;

import com.math.data.Deque;
import com.math.data.Queue;
import com.math.data.Stack;

import java.util.Objects;

public class PackedFactory {
    private final Codec codec;

    public PackedFactory(Codec codec) {
        Objects.requireNonNull(codec);

        this.codec = codec;
    }

    public Stack newStack(int capacity) {
        throw new UnsupportedOperationException();
    }

    public Queue newQueue(int capacity) {
        throw new UnsupportedOperationException();
    }

    public Deque newDeque(int capacity) {
        throw new UnsupportedOperationException();
    }
}
