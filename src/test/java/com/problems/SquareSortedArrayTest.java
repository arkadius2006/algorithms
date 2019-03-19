package com.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SquareSortedArrayTest {

    private SquareSortedArray algorithm;

    @Before
    public void setUp() {
        algorithm = new SquareSortedArray();
    }

    @Test
    public void one() {
        int[] a = {-4, -1, 0, 3, 10};
        int[] b = algorithm.sortedSquares(a);
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, b);
    }

    @Test
    public void two() {
        int[] a = {-7, -3, 2, 3, 11};
        int[] b = algorithm.sortedSquares(a);
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, b);
    }
}
