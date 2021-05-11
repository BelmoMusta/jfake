package musta.belmo.jfake.resolver;

import java.util.Random;

public class FloatResolver extends AbstractResolver<float[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        return new Object[]{random.nextFloat()};
    }


}
