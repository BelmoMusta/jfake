package musta.belmo.jfake.resolver;

import java.util.Random;

public class DoubleResolver extends AbstractResolver<double[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        return new Object[]{random.nextDouble()};
    }


}
