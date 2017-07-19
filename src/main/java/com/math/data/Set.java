package com.math.data;

public interface Set {

    Domain domain();

    Object reduce(SetReduceOperation op);

    int count();

    boolean isEmpty();

    boolean contains(Object o);

    Set add(Object a);

    Set remove(Object a);
}
