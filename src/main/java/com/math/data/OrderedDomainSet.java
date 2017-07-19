package com.math.data;

public interface OrderedDomainSet extends DomainSet {

    @Override
    OrderedDomain domain();

    @Override
    OrderedDomainSet add(Object a);

    @Override
    OrderedDomainSet remove(Object a);

    Object next(Object a);

    Object prev(Object a);

    Object min();

    Object max();

    Object floor(Object a);

    Object ceil(Object a);
}
