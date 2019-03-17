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
 *
 * Overall, algorithm has O(n log(n)) time complexity worst case,
 * and uses O(n) additional space.
 *
 * Below tow steps are performed in one loop: accumulating sum and adding to heap/computing min.
 */
public class MaxSubArrayHeapSolution implements MaxSubArray {

    @Override
    public int maxSubArray(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int currentMax = Integer.MIN_VALUE;

        PriorityQueue<Integer> heap = new PriorityQueue<>(array.length + 1);
        int sum = 0;
        for (int a: array) {
            heap.add(sum);
            int min = heap.element();

            sum += a;
            int candidate = sum - min;

            if (candidate > currentMax) {
                currentMax = candidate;
            }
        }

        return currentMax;
    }

    @Override
    public String toString() {
        return "heap";
    }
}

