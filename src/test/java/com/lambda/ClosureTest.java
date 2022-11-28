package com.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class ClosureTest {

    @Test
    // Test lambda can access local variables in surrounding scope
    // that are declared not final
    // e.g. after outer function is completed
    // this vars continues to live and used in lambda
    public void testLambdaIsClosure() {

        AtomicInteger x = new AtomicInteger(0);
        // x = new AtomicInteger(4); -> this gives error about final
        // or non final var pass to lambda
        Comparator<Integer> cmp = (a, b) -> a - b + x.get();

        Assert.assertTrue(cmp.compare(1, 2) < 0);

        // mutate state
        x.set(10);

        Assert.assertFalse(cmp.compare(1, 2) < 0);
    }

}
