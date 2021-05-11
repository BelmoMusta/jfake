package musta.belmo.jfake.resolver;

import java.util.Random;

public class BooleanResolver extends AbstractResolver<boolean[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        return new Object[]{random.nextInt() % 2 == 0};
    }


}
