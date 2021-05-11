package musta.belmo.jfake.resolver;

import java.util.Random;

public class IntResolver extends AbstractResolver<int[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        return new Object[]{random.nextInt()};
    }


}
