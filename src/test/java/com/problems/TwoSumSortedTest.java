package com.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumSortedTest {
    private TwoSumSorted algorithm;

    @Before
    public void setUpAlgorithm() {
        algorithm = new TwoSumSorted();
    }

    @Test
    public void positive() {
        int a[] = {1, 2};
        int target = 3;

        int [] actual = algorithm.getIndices(a, target);

        Assert.assertArrayEquals(new int[] {0, 1}, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative() {
        int a[] = {1, 2};
        int target = 4;

        algorithm.getIndices(a, target);
    }
}
