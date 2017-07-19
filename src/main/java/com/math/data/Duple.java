package com.math.data;

import java.util.Objects;

public class Duple {
    private final Object key;
    private final Object value;

    public Duple(Object key, Object value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);

        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
