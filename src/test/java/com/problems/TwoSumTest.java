package com.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
    private TwoSum algorithm;

    @Before
    public void setUp() {
        algorithm = new TwoSum();
    }

    @Test
    public void positive() {
        int[] a = {11, 15, 2, 7};
        int target = 9;

        int[] indices = algorithm.getIndices(a, target);
        Assert.assertArrayEquals(new int[]{2, 3}, indices);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative() {
        int[] a = {11, 15, 2, 7};
        int target = 8;

        algorithm.getIndices(a, target);
    }
}
