package musta.belmo.jfake;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Bean {
    private String name;
    private int age;
    private List<Integer> integers;
}
