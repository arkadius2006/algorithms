package com.knuth.permutation;

/**
 * Inverse permutation.
 * Array A holds numbers 0, 1, .., n - 1 in some order.
 * It is required to invert permutation A in-place using O(1) extra memory.
 */
public class InversePermutation {

    public void invert(int[] a, int n) {
        for (int k = 0; k < n; k += 1) {
            if (a[k] >= 0) {
                invertCycle(a, k);
            }
        }

        restoreSign(a, n);
    }

    private void invertCycle(int[] a, int k) {
        int val = k;
        int i = a[k];

        while (i != k) {
            int tmp = a[i];
            a[i] = -1 - val;    // negate to mark cell as "processed"
            // this is to identify any not processed cells after inverting a cycle.
            // after all cells are processed restore sign
            // using formula -1 - val because values are 0-based (just negation turns 0 to 0)
            val = i;
            i = tmp;
        }

        a[i] = -1 - val;
    }

    private void restoreSign(int[] a, int n) {
        for (int i = 0; i < n; i += 1) {
            a[i] = -1 - a[i];
        }
    }
}
