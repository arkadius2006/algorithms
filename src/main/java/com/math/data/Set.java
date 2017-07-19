package com.math.data;

public interface Set {

    Domain domain();

    int count();

    boolean isEmpty();

    boolean contains(Object o);

    Set add(Object a);

    Set remove(Object a);
}
