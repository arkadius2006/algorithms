package com.problems;

import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {
    MajorityElement algorithm = new MajorityElement();

    @Test
    public void one() {
        int a[] = {5};
        int val = algorithm.findMajorityElement(a);
        Assert.assertEquals(5, val);
    }

    @Test
    public void two() {
        int a[] = {3, 3};
        int val = algorithm.findMajorityElement(a);
        Assert.assertEquals(3, val);
    }

    @Test
    public void three() {
        int a[] = {5, 3, 5};
        int val = algorithm.findMajorityElement(a);
        Assert.assertEquals(5, val);
    }

    @Test
    public void four() {
        int a[] = {5, 3, 5, 5};
        int val = algorithm.findMajorityElement(a);
        Assert.assertEquals(5, val);
    }

    @Test
    public void five() {
        int a[] = {5, 3, 5, 5, 3};
        int val = algorithm.findMajorityElement(a);
        Assert.assertEquals(5, val);
    }
    
}
