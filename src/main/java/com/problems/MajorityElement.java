package com.problems;

/**
 * Given array of integers A. A is known to contain majority element:
 * the same value repeats more than n/2 times in array, where n = length(A).
 */
public class MajorityElement {

    public int findMajorityElement(int[] elements) {
        int count = 0;
        int val = 0;

        for (int e: elements) {
            if (count == 0) {
                val = e;
                count = 1;
            } else if (e == val) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return val;
    }
}
