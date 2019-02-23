package com.knuth.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JoinerTest {

    Joiner joiner;

    private static int[] of(int... a) {
        return a;
    }

    private static int[] empty() {
        return of();
    }

    @Before
    public void setUpJoiner() {
        joiner = new Joiner();
    }

    @Test
    public void emptyLeft() {
        int[] result = joiner.join(empty(), of(1));

        Assert.assertArrayEquals(empty(), result);
    }

    @Test
    public void emptyRight() {
        int[] result = joiner.join(of(1), empty());

        Assert.assertArrayEquals(empty(), result);
    }

    @Test
    public void bothContainSingleElementTheSame() {
        int[] result = joiner.join(of(1), of(1));

        Assert.assertArrayEquals(of(1), result);
    }

    @Test
    public void bothContainSingleElementDifferent() {
        int[] result = joiner.join(of(1), of(2));

        Assert.assertArrayEquals(empty(), result);
    }
}
