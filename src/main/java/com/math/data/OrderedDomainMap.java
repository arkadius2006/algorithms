package com.math.data;

public interface OrderedDomainMap extends DomainMap {

    @Override
    OrderedDomain keyDomain();

    @Override
    OrderedDomainMap add(Object key, Object value);

    @Override
    OrderedDomainMap replace(Object key, Object newValue);

    @Override
    OrderedDomainMap remove(Object key);

    Duple nextDuple(Object a);

    Duple prevDuple(Object a);

    Duple minDuple();

    Duple maxDuple();

    Duple floorDuple(Object a);

    Duple ceilDuple(Object a);
}
