package musta.belmo.jfake;

import java.util.Random;

public class MyRandom extends Random {
    private final int seed;

    public MyRandom(int seed) {
        this.seed = seed;
    }

    @Override
    public int nextInt() {
        return (int) (Math.random() * 10000 * seed);
    }

    @Override
    public long nextLong() {
        return (long) (Math.random() * 10000 * seed);

    }

    @Override
    public boolean nextBoolean() {
        return (int) (Math.random() * 10000 * seed) % 2 == 0;

    }

    @Override
    public float nextFloat() {
        return (float) (Math.random() * 10000.0 * seed);
    }

    @Override
    public double nextDouble() {
        return Math.random() * 10000.0 * seed;

    }
}
