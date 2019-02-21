package com.math.data.impl;

class IntUtils {

    public static int inc(int i, int n) {
        checkModule(n);
        checkIndex(i, n);
        ++i;
        return i < n ? i : 0;
    }

    public static int dec(int i, int n) {
        checkModule(n);
        checkIndex(i, n);
        --i;
        return i >= 0 ? i : n - 1;
    }

    private static void checkModule(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Divisor cannot be negative or zero: " + n);
        }
    }

    private static void checkIndex(int i, int n) {
        if (i < 0 || i >= n) {
            throw new IllegalArgumentException("Index out of range: " + i + ", module: " + n);
        }
    }
}
