package musta.belmo.jfake;

import musta.belmo.jfake.resolver.Resolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Faker<T> {
    final Class<T> aClass;

    public Faker(Class<T> aClass) {
        this.aClass = aClass;
    }

    public T get() throws FakerException {
        T t;
        try {
            t = aClass.newInstance();
            final List<Method> setters = getSetters();

            for (Method setter : setters) {
                Parameter[] parameters = setter.getParameters();
                Object[] values = params(parameters);
                if (values.length == 1) {
                    setter.invoke(t, values);
                }
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new FakerException(e);
        }
        return t;
    }

    private List<Method> getSetters() {
        return Stream.of(aClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> method.getParameters().length == 1) // some methods may be named 'setXXX' with more than one parameter
                .collect(Collectors.toList());
    }

    private Object[] params(Parameter[] parameters) {
        Parameter parameter = parameters[0];
        Class<?> type = parameter.getType();

        return new Resolver().randomValue(type);
    }
}
