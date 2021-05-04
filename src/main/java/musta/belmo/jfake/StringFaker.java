package musta.belmo.jfake;

public class StringFaker extends Faker<String> {
    public StringFaker() {
        super(String.class);
    }

    @Override
    public String get() throws FakerException {
        return "fake";
    }
}
