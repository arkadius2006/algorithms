package com.math.data;

public interface OrderedSet extends Set {

    @Override
    OrderedDomain domain();

    @Override
    OrderedSet add(Object a);

    @Override
    OrderedSet remove(Object a);

    Object next(Object a);

    Object prev(Object a);

    Object min();

    Object max();

    Object floor(Object a);

    Object ceil(Object a);
}
