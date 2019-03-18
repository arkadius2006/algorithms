package com.problems;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Math explanation. Let's start from some number i within [0, n) and iteratively add k (mod n).
 * After L steps the process returns to original number i. All numbers in this sequence
 * being different, e.g. i is the first duplicate:
 * i, i + k, i + 2k, ..., i + (L - 1)k, i + Lk == i (mod n)
 *
 * This sequence is called the cycle (or orbit).
 * It's length L does not depend on the choice of the first number i, obviously.
 *
 * Let's choose another number i_2, which is not in the first sequence, and repeat the same process.
 * We'll get another cycle. It has no common points with the first one -- otherwise they will be identical
 * (the cycle is completely defined by any point).
 *
 * Repeat the process until there are points in 0..n-1, not covered by found cycles. Finally, we have:
 * the whole set 0..n-1 is covered by several cycles, that has no common points with each other, and each has length L.
 * Number of cycles is n/L.
 *
 * Actually, numbers i and j belong to the same cycle if and only if i = j (mod d), where d = gcd(n,k).
 * gdc is abbreviation for Greatest Common Divisor.
 *
 * In other worlds, the sequence
 * 0, k, 2k, 3k, ... (mod n)
 * contains exactly numbers
 * 0, d, 2d, ... (s-1) * d
 * where s * d = n;
 *
 * Example. n = 10, k = 6. The sequence i * k (mod n), i = 0, 1, 2, .. is:
 * 0, 6, 2, 8, 4
 * which is actually rearranging of:
 * 0, 2, 4, 6, 8
 * Observe that gcd(6, 10) = 2
 *
 * This means that there are exactly d = gdc(n, k) different cycles which are:
 *     0 + i * d, i = 0, .., s - 1
 *     1 + i * d, i = 0, .., s - 1
 * ...
 * (d-1) + i * d, i = 0, .., s - 1
 *
 * Each has length s = n/d. So, L = n/d.
 *
 * So algorithm is:
 * Start with i = 0. Copy a[i] to a[i + k]. Store a[i + k] to tmp var before. Repeat the same
 * for i = i + k. Use memorized value a[i+k]. Etc. Repeat exactly n/d steps.
 * This guarantees we algorithm returns to the original point and runs through complete cycle.
 *
 * Repeat the same loop starting from i = 1.
 * ...
 * Repeat the same loop starting from i = d-1.
 * Thus algorithms runs through each of d cycles and rotates complete array by k
 * positions to the right.
 *
 * Time complexity is O(n). Memory complexity is O(1).
 *
 * Of cause, we need to find d = gcd(n, k). This is computed by Euclid algorithm
 * which has O (log n) complexity.
 */
class RotateArray {

    public void rotate(int[] a, int k) {
        int n = a.length;

        if (n == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        k = k % n;


        if (k == 0) {
            return;
        }

        int d = gcd(n, k);
        int l = n/d;

        for (int i = 0; i < d; i += 1) {
            rotateCycle(a, k, i, l);
        }
    }

    private void rotateCycle(int[] a, int k, int i, int count) {
        int n = a.length;

        int val = a[i];
        int j = (i + k) % n;
        while (count > 0) {
            val = swap(a, j, val);

            i = j;
            j = (j + k) % n;
            count -= 1;
        }
        // math note: after count = n/d iterations algorithm return to the original index
    }

    // write val to a[i]
    // return old value
    private int swap(int[] a, int i, int val) {
        int old = a[i];
        a[i] = val;
        return old;
    }

    private int gcd(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Both numbers should be positive");
        }

        if (a == b) {
            return a;
        }

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int r = a % b;
        while (r > 0) {
            a = b;
            b = r;
            r = a % b;
        }

        return b;
    }
}