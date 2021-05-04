package musta.belmo.jfake;


import org.junit.Assert;
import org.junit.Test;


public class FakerTest {
    @Test
    public void testGet() {
        Faker<Bean> beanFaker = new Faker<>(Bean.class);
        Bean bean = beanFaker.get();
        Assert.assertNotNull(bean);
    }

}