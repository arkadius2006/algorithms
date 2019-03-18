package com.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeTwoSortedArraysInPlaceTest {

    private MergeTwoSortedArraysInPlace algorithm;

    @Before
    public void setUp() {
        algorithm = new MergeTwoSortedArraysInPlace();
    }

    @Test
    public void test() {
        int[] a = {2, 5, 6, 0, 0, 0};
        int[] b = {1, 2, 3};
        algorithm.merge(a, 3, b, 3);

        Assert.assertArrayEquals(new int[] {1, 2, 2, 3, 5, 6}, a);
    }

}
