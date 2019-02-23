package com.knuth.sorting;

import java.util.Arrays;

/**
 * Find all common elements of two sorted arrays.
 */
public class Joiner {

    public int[] join(int[] a, int[] b) {
        int na = a.length;
        int nb = b.length;

        int k = 0;
        int[] commons = new int[a.length];

        int i = 0;
        int j = 0;
        while (i < na && j < nb) {
            if (a[i] < b[j]) {
                i += 1;
            } else if (b[j] < a[i]) {
                j += 1;
            } else {
                commons[k] = a[i];
                k += 1;
                i += 1;
                j += 1;
            }
        }

        return Arrays.copyOf(commons, k);
    }
}
