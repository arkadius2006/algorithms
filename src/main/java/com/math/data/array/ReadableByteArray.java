package com.math.data.array;

public interface ReadableByteArray {

    int length();

    byte get(int i) throws IndexOutOfBoundsException;
}
