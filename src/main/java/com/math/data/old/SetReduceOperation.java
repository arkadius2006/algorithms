package com.math.data.old;

public interface SetReduceOperation {

    Object init();

    Object add(Object augend, Object addend);

    Object complete(Object sum);
}
