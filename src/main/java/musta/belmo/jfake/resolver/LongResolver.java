package musta.belmo.jfake.resolver;

import java.util.Random;

public class LongResolver extends AbstractResolver<long[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        return new Object[]{random.nextLong()};
    }
}
