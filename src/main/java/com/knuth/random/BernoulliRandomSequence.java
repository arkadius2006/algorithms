package com.knuth.random;

import java.util.Random;

/**
 * Defines random variable X such that:
 * X = 1 with probability p
 * X = 0 with probability 1-p
 * <p>
 * Probabilities p and 1-p are defined via integer weights a and b:
 * p = a/(a+b), 1-p = b/(a+b)
 */
public class BernoulliRandomSequence implements RandomSequence {
    private final Random random;
    private final int a;
    private final int b;

    public BernoulliRandomSequence(int a, int b) {
        if (a <= 0) {
            throw new IllegalArgumentException("a < 0");
        }

        if (b <= 0) {
            throw new IllegalArgumentException("b < 0");
        }

        this.a = a;
        this.b = b;
        random = new Random();
    }

    @Override
    public int next() {
        int x = random.nextInt(a + b);
        return (x < a ? 1 : 0);
    }
}
