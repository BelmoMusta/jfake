package musta.belmo.jfake.resolver;

import java.util.Random;

public class CharResolver extends AbstractResolver<char[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        char c = (char) (random.nextInt(26) + 'a');
        return new Object[]{c};

    }


}
