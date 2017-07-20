package com.math.data.impl;

import org.junit.Assert;
import org.junit.Test;

public class IntUtilsTest {

    @Test
    public void testIncNormal() {
        Assert.assertEquals(1, IntUtils.inc(0, 2));
    }

    @Test
    public void testIncrementWrap() {
        Assert.assertEquals(0, IntUtils.inc(1, 2));
    }


    @Test
    public void testDecNormal() {
        Assert.assertEquals(0, IntUtils.dec(1, 2));
    }

    @Test
    public void testDecWrap() {
        Assert.assertEquals(1, IntUtils.dec(0, 2));
    }
}
