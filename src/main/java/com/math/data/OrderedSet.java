package com.math.data;

public interface OrderedSet extends Set {

    @Override
    OrderedDomain domain();

    @Override
    OrderedSet add(Object a) throws DuplicateKeyException;

    @Override
    OrderedSet remove(Object a) throws NoKeyException;

    Object higher(Object a) throws NoKeyException;

    Object lower(Object a) throws NoKeyException;

    Object min() throws NoKeyException;

    Object max() throws NoKeyException;

    Object floor(Object a) throws NoKeyException;

    Object ceil(Object a) throws NoKeyException;
}
