package musta.belmo.jfake;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.jfake.annotation.FakeValue;

import javax.xml.soap.Text;
import java.util.List;


@Getter
@Setter
public class BeanFaker {
    @FakeValue
    private String name;
    private Text text;
    private int age;
    private float aFloat;
    private double aDouble;
    private char aChar;
    private byte aByte;
    private long aLong;
    private boolean aBoolean;
    private List<Integer> integers;


}
