package com.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class MaxSubArrayTest {

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<?> data() {
        return Arrays.asList(
                new MaxSubArrayDivideAndConquerSolution(),
                new MaxSubArrayHeapSolution());
    }

    private final MaxSubArray algorithm;

    public MaxSubArrayTest(MaxSubArray algorithm) {
        this.algorithm = algorithm;
    }

    @Test
    public void test() {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};

        int max = algorithm.maxSubArray(a);
        Assert.assertEquals(6, max);
    }
}
