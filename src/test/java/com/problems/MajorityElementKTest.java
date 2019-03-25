package com.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MajorityElementKTest {

    @Test
    public void one() {
        int[] a = {1, 1, 2};
        MajorityElementK algorithm = new MajorityElementK(a, 3);
        int[] values = algorithm.findAllMajorityElements();
        Assert.assertArrayEquals(values, new int[] {1});
    }

    @Test
    public void two() {
        int[] a = {1, 1, 2, 2};
        MajorityElementK algorithm = new MajorityElementK(a, 3);
        int[] values = algorithm.findAllMajorityElements();
        Arrays.sort(values);
        Assert.assertArrayEquals(values, new int[] {1, 2});
    }

}
