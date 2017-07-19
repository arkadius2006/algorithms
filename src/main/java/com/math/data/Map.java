package com.math.data;

public interface Map {

    Domain keyDomain();

    boolean containsKey(Object key);

    Duple getDuple(Object key);

    Map add(Object key, Object value);

    Map replace(Object key, Object newValue);

    Map remove(Object key);
}
