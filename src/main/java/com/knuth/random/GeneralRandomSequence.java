package com.knuth.random;

import java.util.Arrays;
import java.util.Random;

/**
 * Random variable X takes values 0, .., n - 1 with probabilities
 * a_0, .., a_{n-1}.
 * <p/>
 * E.g.
 * P(X = k) = a_k for each k = 0, .., n - 1.
 */
public class GeneralRandomSequence implements RandomSequence {
    private final int[] a;
    private final int sum;
    private final Random random;

    public GeneralRandomSequence(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i += 1) {
            if (a[i] < 0) {
                throw new IllegalArgumentException("Probability p[" + i + "] < 0");
            }
            sum += a[i];
        }

        if (sum == 0) {
            throw new IllegalArgumentException("All probabilities are zero");
        }

        this.a = Arrays.copyOf(a, a.length);
        this.sum = sum;
        this.random = new Random();
    }

    @Override
    public int next() {
        int x = random.nextInt(sum);
        // a[0] chances for 0
        // a[1] chances for 1
        // ...

        // implementation note: can use binary search to get O(log(n)) performance
        // instead of O(n), where n = a.length()
        int s = 0;
        for (int i = 0; i < a.length; i += 1) {
            s += a[i];
            if (x < s) {
                return i;
            }
        }

        // s == sum at the end of loop
        // since x < sum  by definition of x
        // we have: x < s ar some iteration
        // so, this point is not reachable
        throw new RuntimeException("Not reachable");
    }
}
