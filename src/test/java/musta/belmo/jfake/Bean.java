package musta.belmo.jfake;

import lombok.Getter;
import lombok.Setter;

import javax.xml.soap.Text;
import java.util.List;


@Getter
@Setter
public class Bean {
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
