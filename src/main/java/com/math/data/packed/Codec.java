package com.math.data.packed;

import com.math.data.array.ReadableByteArray;
import com.math.data.array.WritableByteArray;

public interface Codec {

    void encode(Object src, WritableByteArray dest) throws EncodeException;

    Object decode(ReadableByteArray dest) throws DecodeException;
}
