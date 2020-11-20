package com.knuth.sequence;

public interface Sequence {

    int first();

    Sequence following(); // could be null: empty sequence
}
