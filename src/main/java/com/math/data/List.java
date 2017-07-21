package com.math.data;

public interface List {

    boolean isEmpty();

    Pointer head();

    static interface Pointer {

        boolean isHead();

        Object get();

        Pointer next();

        Pointer prev();

        void set(Object o);

        void insertNext(Object o);

        void insertPrev(Object o);

        void removeNext();

        void removePrev();
    }
}
