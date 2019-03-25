package com.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MajorityElementKTest {

    private final MajorityElementK algorithm = new MajorityElementK();

    @Test
    public void one() {
        int[] a = {1, 1, 2};
        int[] values = algorithm.findAllMajorityElements(a, 3);
        Assert.assertArrayEquals(values, new int[] {1});
    }

    @Test
    public void two() {
        int[] a = {1, 1, 2, 2};
        int[] values = algorithm.findAllMajorityElements(a, 3);
        Arrays.sort(values);
        Assert.assertArrayEquals(values, new int[] {1, 2});
    }

}
