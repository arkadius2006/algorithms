package com.math.data.array;

public interface ArrayFactory {

    ByteArray newPortion(byte[] data, int fromIndex, int length);

    ReadableByteArray newReadablePortion(byte[] data, int fromIndex, int length);

    WritableByteArray newWritablePortion(byte[] data, int fromIndex, int length);

    ByteArray newPortion(ByteArray array, int fromIndex, int length);

    ReadableByteArray newReadablePortion(ReadableByteArray array, int fromIndex, int length);

    WritableByteArray newWritableByteArray(WritableByteArray array, int fromIndex, int length);
}
