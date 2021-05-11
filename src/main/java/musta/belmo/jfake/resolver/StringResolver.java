package musta.belmo.jfake.resolver;

import java.util.Random;

public class StringResolver extends AbstractResolver<String[]> {

    @Override
    public String[] resolve() {
        Random random = getRandom();
        return new String[]{"test random" + random.nextInt()};
    }


}
