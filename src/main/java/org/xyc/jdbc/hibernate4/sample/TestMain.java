package org.xyc.jdbc.hibernate4.sample;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bugu on 2016/2/20.
 */
public class TestMain {

    TestService testService;

    @Before
    public void before() {
        String paths[] = {"applicationContext-hibernate.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);

        testService = (TestService)ctx.getBean("testService");
    }

    @Test
    public void save() {
        TestModel testModel = new TestModel();
        testModel.setName("abc");
        testModel.setAge(15);
        testModel.setAddress("hello");
        testService.save(testModel);
        Assert.assertNotNull("");
    }

    @Test
    public void update() {
        testService.update(1, "mail");
        Assert.assertNotNull("");
    }
}
