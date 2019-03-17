package com.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxSubArrayTest {

    private MaxSubArray algorithm;

    @Before
    public void seUp() {
        algorithm = new MaxSubArray();
    }

    @Test
    public void test() {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};

        int max = algorithm.maxSubArray(a);
        Assert.assertEquals(6, max);
    }
}
