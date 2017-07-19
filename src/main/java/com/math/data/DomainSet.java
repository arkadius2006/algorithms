package com.math.data;

public interface DomainSet {

    Domain domain();

    int count();

    boolean isEmpty();

    boolean contains(Object o);

    DomainSet add(Object a);

    DomainSet remove(Object a);
}
