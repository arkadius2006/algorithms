package com.math.data;

public interface ListReduceOperation {
    Object init();

    Object add(Object augend, Object addend);

    Object complete(Object sum);
}
