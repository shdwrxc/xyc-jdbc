package org.xyc.jdbc.spring4;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by wks on date: 2017/6/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jdbc.xml")
public class SpringJdbcTest {

    @Autowired
    private SpringJdbcService jdbcService;

    @Test
    public void testSave() {
        int i = jdbcService.save();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testBatchSave() {
        int i = jdbcService.batchSave();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testUpdate() {
        int i = jdbcService.update();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testDelete() {
        int i = jdbcService.delete();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testGetAllGondria() {
        List<Map<String, Object>> list = jdbcService.getAllGondria();
        System.out.println(list);
    }

    @Test
    public void testGetGondriaById() {
        GondriaModel model = jdbcService.getGondriaById();
        System.out.println(model);
    }

    @Test
    public void testInsertTwoGondria() {
        jdbcService.insertTwoGondria();
        System.out.println();
    }
}
