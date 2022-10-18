package com.tinkoff;

import org.junit.Assert;
import org.junit.Test;

public class MaxSequenceTest {

    private MaxSequence algo = new MaxSequence();

    @Test
    public void twoSequencesSeparatedByOneZero() {
        // build input
        int[] a = fromString("110111");

        // invoke test method
        int max = algo.computeMaxSequence(a);

        // check result
        Assert.assertEquals(5, max);
    }

    @Test
    public void twoSequencesSeparatedByTwoZeros() {
        // build input
        int[] a = fromString("1100111");

        // invoke test method
        int max = algo.computeMaxSequence(a);

        // check result
        Assert.assertEquals(3, max);
    }

    @Test
    public void threeSequences() {
        // build input
        int[] a = fromString("10111011");

        // invoke test method
        int max = algo.computeMaxSequence(a);

        // check result
        Assert.assertEquals(5, max);
    }

    // parse 0,1 string to int array
    // each string element is expected to be either "0" or "1"
    private static int[] fromString(String s) {
        int n = s.length();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '1') {
                a[i] = 1;
            } else if (c == '0') {
                // do nothing, a[i] already == 0
            } else {
                throw new IllegalArgumentException("Unexpected char (" + "'" + c + "' at position " + i + ". " +
                        "For input string: " + s); // todo use String.format()
            }
        }

        return a;
    }
}











