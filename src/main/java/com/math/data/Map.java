package com.math.data;

public interface Map {

    Domain keyDomain();

    Object reduce(MapReduceOperation op);

    boolean containsKey(Object key);

    Duple getDuple(Object key) throws NoKeyException;

    Map add(Object key, Object value) throws DuplicateKeyException;

    Map replace(Object key, Object newValue) throws NoKeyException;

    Map remove(Object key) throws NoKeyException;
}
