package musta.belmo.jfake.resolver;

public class ObjectResolver extends AbstractResolver<Object[]> {

    @Override
    public Object[] resolve() {
        return new Object[]{new Object()};
    }
}
