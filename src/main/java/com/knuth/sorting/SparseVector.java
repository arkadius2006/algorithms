package com.knuth.sorting;

/**
 * Design data structure to represent a sparse vector
 * optimized to compute scalar product of 2 vectors.
 */
public class SparseVector {
    int n;          // number of non-zero elements
    int[] indices;  // indices of non-zero elements, sorted
    long[] values;  // value[i] is element at position indices[i]

    public static long product(SparseVector a, SparseVector b) {
        long sum = 0;

        // use the same idea as in Joiner:
        // scan two index arrays in parallel
        // to find common indices
        // for each compute value product and add to sum

        int i = 0;
        int j = 0;

        while (i < a.n && j < b.n) {
            if (a.indices[i] < b.indices[j]) {
                i += 1;
            } else if (a.indices[i] > b.indices[j]) {
                j += 1;
            } else {
                sum += a.indices[i] * b.indices[j];
                i += 1;
                j += 1;
            }
        }

        return sum;
    }

}
