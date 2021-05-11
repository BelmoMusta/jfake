package musta.belmo.jfake.resolver;

import musta.belmo.jfake.MyRandom;

import java.util.Random;

public abstract class AbstractResolver<T> {
    public abstract Object[] resolve();

    protected Random getRandom() {
        return new MyRandom(10000);
    }
}
