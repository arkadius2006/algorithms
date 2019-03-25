package com.problems;

import java.util.Arrays;

/**
 * Given array A, and integer k > 1, find all elements that appear in array
 * more than n/k times.
 */
public class MajorityElementK {

    public int[] findAllMajorityElements(int[] elements, int k) {
        int[] counts = new int[k - 1];
        int[] values = new int[k - 1];

        for (int e : elements) {
            // match incoming value
            int i = search(e, values, counts);
            if (i >= 0) {
                ++counts[i];
                continue;
            }

            // search empty slot
            i = searchEmpty(counts);
            if (i >= 0) {
                values[i] = e;
                counts[i] = 1;
                continue;
            }

            // remove 1 element from each group
            decrementAll(counts);
        }

        // values are just candidates, need to test
        for (int i = 0; i < values.length; i += 1) {
            if (counts[i] > 0) {
                counts[i] = countMatches(values[i], elements);
            }
        }

        int n = elements.length;
        return getValuesWhereCountExceeds(values, counts, n/k);
    }

    private int search(int e, int[] values, int[] counts) {
        for (int i = 0; i < values.length; i += 1) {
            if (counts[i] > 0 && values[i] == e) {
                return i;
            }
        }

        return -1;
    }

    private int searchEmpty(int[] counts) {
        for (int i = 0; i < counts.length; i += 1) {
            if (counts[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    private void decrementAll(int[] counts) {
        for (int i = 0; i < counts.length; i += 1) {
            --counts[i];
        }
    }

    private int countMatches(int val, int[] a) {
        int count = 0;
        for (int e: a) {
            if (e == val) {
                count += 1;
            }
        }

        return count;
    }

    private int[] getValuesWhereCountExceeds(int[] values, int[] counts, int limit) {
        int[] tmp = new int[values.length];
        int j = 0;

        for (int i = 0; i < values.length; i += 1) {
            if (counts[i] > limit) {
                tmp[j] = values[i];
                j += 1;
            }
        }

        return Arrays.copyOf(tmp, j);
    }
}
