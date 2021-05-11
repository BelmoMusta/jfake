package musta.belmo.jfake.resolver;

import java.util.Random;

public class ByteResolver extends AbstractResolver<byte[]> {

    @Override
    public Object[] resolve() {
        Random random = getRandom();
        return new Object[]{(byte) random.nextInt()};
    }


}
