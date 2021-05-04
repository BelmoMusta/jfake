package musta.belmo.jfake;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Faker<T> {

    final Class<T> aClass;

    public Faker(Class<T> aClass) {
        this.aClass = aClass;
    }

    public T get() throws FakerException {
        T t;
        if (isPrimitive()) {
            return null;
        } else {
            try {
                t = aClass.newInstance();
                List<Method> declaredMethods = Stream.of(aClass.getDeclaredMethods())
                        .filter(method -> method.getName().startsWith("set"))
                        .collect(Collectors.toList());

                for (Method setters : declaredMethods) {
                    Parameter[] parameters = setters.getParameters();
                    Object[] values = params(parameters);
                    setters.invoke(t, values);
                }

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new FakerException(e);
            }
        }
        return t;
    }

    private Object[] params(Parameter[] parameters) {
        Object[] values = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Class<?> type = parameter.getType();
            if (isPimitive(type)) {
                randomValue(type);
            }
            values[i] = randomValue(type)[0];
        }
        return values;
    }

    private boolean isPrimitive() {

        Class<T> type = this.aClass;
        return isPimitive(type);
    }

    private boolean isPimitive(Class<?> type) {
        return type.isPrimitive() || type == String.class;
    }

    private Object[] randomValue(Class<?> type) {

        Map<Class<?>, Supplier<Object[]>> randValues = new LinkedHashMap<>();
        randValues.put(int.class, () -> new Object[]{new Random(10000).nextInt()});
        randValues.put(long.class, () -> new Object[]{new Random(10000).nextLong()});
        randValues.put(String.class, () -> new Object[]{"test random" + new Random(10000).nextInt()});
        if (!randValues.containsKey(type)) {
            return new Object[]{null};
        }
        return randValues.get(type).get();
    }
}
