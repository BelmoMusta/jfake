package musta.belmo.jfake.resolver;


import java.util.ArrayList;
import java.util.List;

public class ListResolver extends AbstractResolver<List[]> {

    @Override
    public Object[] resolve() {
        return new List[]{new ArrayList<>()};
    }
}
