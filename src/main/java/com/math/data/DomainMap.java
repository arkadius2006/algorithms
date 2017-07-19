package com.math.data;

public interface DomainMap {

    Domain keyDomain();

    boolean containsKey(Object key);

    Duple getDuple(Object key);

    DomainMap add(Object key, Object value);

    DomainMap replace(Object key, Object newValue);

    DomainMap remove(Object key);
}
