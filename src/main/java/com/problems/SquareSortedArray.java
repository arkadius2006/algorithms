package com.problems;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Solution that uses only n cells of additional memory where result is stored.
 */
public class SquareSortedArray {

    public int[] sortedSquares(int[] a) {
        int n = a.length;
        int[] b = new int [n];

        int j = indexOfFirstNonNegativeElement(a);
        int i = j - 1;

        // squares from j and up are sorted asc
        // square from i and down are sorted asc
        // merge two sorted arrays into sorted array
        int k = 0;
        while (i >= 0 && j < n) {
            int x = a[i] * a[i];
            int y = a[j] * a[j];

            if (x <= y) {
                b[k++] = x;
                i--;
            } else {
                b[k++] = y;
                j++;
            }
        }

        while (i >= 0) {
            b[k++] = a[i] * a[i];
            i--;
        }

        while (j < n) {
            b[k++] = a[j] * a[j];
            j++;
        }

        return b;
    }

    // returns smallest k: a[k] >= 0, or n (array length) if forall k: a[k] < 0
    private int indexOfFirstNonNegativeElement(int[] a) {
        int n = a.length;

        int i = 0;
        while (i < n && a[i] < 0) {
            i += 1;
        }

        return i;
    }
}

