package com.math.data;

public interface OrderedMap extends Map {

    @Override
    OrderedDomain keyDomain();

    @Override
    OrderedMap add(Object key, Object value) throws DuplicateKeyException;

    @Override
    OrderedMap replace(Object key, Object newValue) throws NoKeyException;

    @Override
    OrderedMap remove(Object key) throws NoKeyException;

    Duple higherDuple(Object a) throws NoKeyException;

    Duple lowerDuple(Object a) throws NoKeyException;

    Duple minDuple() throws NoKeyException;

    Duple maxDuple() throws NoKeyException;

    Duple floorDuple(Object a) throws NoKeyException;

    Duple ceilDuple(Object a) throws NoKeyException;
}
