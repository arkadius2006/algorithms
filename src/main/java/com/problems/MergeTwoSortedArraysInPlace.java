package com.problems;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Array A has m elements, but there is enough space in A to hold additional n elements from B.
 *
 * Try find in-place solution, without using additional O(m + n) memory.
 */
public class MergeTwoSortedArraysInPlace {

    // Use free space at the end of A. Scan both array from right to left
    // find max at each iteration and put to the end of A (start from m + n - 1).
    // Since A has enough space we never erase A elements that has not been moved already.
    // This way we use A both as output and input.
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Until either A or B is exhausted
        while (i >= 0 && j >= 0) {
            if (a[i] <= b[j]) { // <= for stable sort (assume bs are after as)
                a[k] = b[j];
                j -= 1;
            } else {
                a[k] = a[i];
                i -= 1;
            }

            k -= 1;
        }

        // now either A or B is exhausted
        // if B is exhausted, we are done: all As are already in place
        // if A is exhausted, just copy whatever left in B to A
        // at this point k == j.
        while (j >= 0) {
            a[j] = b[j];
            j -= 1;
        }
    }
}
