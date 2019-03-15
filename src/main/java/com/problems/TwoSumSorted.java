package com.problems;

/**
 * The same as {@link TwoSum}, but array is known to be sorted.
 */
public class TwoSumSorted {

    public int[] getIndices(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            int val = a[i] + a[j];

            if (val < target) {
                i += 1;
            } else if (val > target) {
                j -= 1;
            } else {
                return new int[]{i, j};
            }
        }

        throw new IllegalArgumentException("Match not found");
    }
}
