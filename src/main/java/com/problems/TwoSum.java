package com.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p/>
 * ref="https://leetcode.com/problems/two-sum/"
 */
public class TwoSum {

    public int[] getIndices(int[] a, int target) {
        // map: a[i] -> i
        Map<Integer, Integer> indices = new HashMap<>();

        for (int j = 0; j < a.length; j += 1) {
            int val = a[j];

            int complement = target - val;
            Integer i = indices.get(complement);

            if (i != null) {
                return new int[]{i, j};
            } else {
                indices.put(val, j);
            }
        }

        throw new IllegalArgumentException("Match not found");
    }
}
