package com.problems;

import java.util.PriorityQueue;

/**
 * Given an integer array, find the contiguous subarray (containing at least
 * one number) which has the largest sum and return its sum.
 *
 * APPROACH.
 * Sum within any continuous range [i,j) is actually difference of two 0-based sums:
 * sum a[k] (i <= k < j) = b[j] - b[i], where b[i] = sum a[k], k < i.
 *
 * Algorithm operate in two steps.
 * 1. Compute partial sums b[i].
 * 2. Find max difference b[j] - b[i] provided that i < j ("ordered difference").
 *
 * To accomplish second step observe:
 * max_{i < j} (b[j] - b[i]) = max_{j} q[j]
 * where q[j] = b[j] - min{i < j} b[i]
 *
 * So we need some data structure to which we can add b[i] one-by-one and efficiently find minimum b[i], i < j.
 * That purpose is accomplished by min-heap data structure.
 *
 * It has efficient min() and add() operations - both O(log n).
 */
public class MaxSubArrayHeapSolution {

    public int maxSubArray(int[] a) {
        if (a.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int[] b = computePartialSums(a);
        return findMaxOrderedDifference(b);
    }

    private int[] computePartialSums(int[] a) {
        int n = a.length;
        int[] s = new int[n + 1];

        s[0] = 0;
        for (int k = 0; k < n; k += 1) {
            s[k + 1] = s[k] + a[k];
        }

        return s;
    }

    // find max (b[j] - b[i]), i < j
    private int findMaxOrderedDifference(int[] b) {
        int m = b.length;
        int currentMax = Integer.MIN_VALUE;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(b[0]);
        for (int j = 1; j < m; j += 1) {
            // at this point heap contains all elements before b[j], but not b[j]
            int min = heap.element();
            int val = b[j] - min;

            if (val > currentMax) {
                currentMax = val;
            }

            heap.add(b[j]);
        }

        return currentMax;
    }
}

