package musta.belmo.jfake.resolver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Resolver {

    public static final Map<Class<?>, AbstractResolver<?>> RAND_VALUES = new LinkedHashMap<>();

    static {
        RAND_VALUES.put(int.class, new IntResolver());
        RAND_VALUES.put(long.class, new LongResolver());
        RAND_VALUES.put(char.class, new CharResolver());
        RAND_VALUES.put(byte.class, new ByteResolver());
        RAND_VALUES.put(float.class, new FloatResolver());
        RAND_VALUES.put(double.class, new DoubleResolver());
        RAND_VALUES.put(boolean.class, new BooleanResolver());
        RAND_VALUES.put(String.class, new StringResolver());
        RAND_VALUES.put(Object.class, new ObjectResolver());
        RAND_VALUES.put(List.class, new ListResolver());
    }

    public Object[] randomValue(Class type) {
        if (!RAND_VALUES.containsKey(type)) {
            return new Object[0];
        }
        AbstractResolver<?> abstractResolver = RAND_VALUES.get(type);
        return abstractResolver.resolve();
    }
}
