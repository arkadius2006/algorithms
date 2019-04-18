package com.knuth.permutation;

import org.junit.Assert;
import org.junit.Test;

public class InversePermutationTest {

    private InversePermutation algorithm = new InversePermutation();

    @Test
    public void identity() {
        int a[] = new int[]{0, 1, 2};
        algorithm.invert(a, a.length);
        Assert.assertArrayEquals(new int[]{0, 1, 2}, a);
    }

    @Test
    public void two() {
        int a[] = new int[]{1, 0};
        algorithm.invert(a, a.length);
        Assert.assertArrayEquals(new int[]{1, 0}, a);
    }

    @Test
    public void four() {
        int[] a = new int[]{2, 3, 0, 1};
        algorithm.invert(a, a.length);
        Assert.assertArrayEquals(new int[]{2, 3, 0, 1}, a);
    }

    @Test
    public void three() {
        int[] a = new int[]{1, 2, 0};
        algorithm.invert(a, a.length);
        Assert.assertArrayEquals(new int[]{2, 0, 1}, a);
    }
}
