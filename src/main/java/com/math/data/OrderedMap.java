package com.math.data;

public interface OrderedMap extends Map {

    @Override
    OrderedDomain keyDomain();

    @Override
    OrderedMap add(Object key, Object value);

    @Override
    OrderedMap replace(Object key, Object newValue);

    @Override
    OrderedMap remove(Object key);

    Duple nextDuple(Object a);

    Duple prevDuple(Object a);

    Duple minDuple();

    Duple maxDuple();

    Duple floorDuple(Object a);

    Duple ceilDuple(Object a);
}
