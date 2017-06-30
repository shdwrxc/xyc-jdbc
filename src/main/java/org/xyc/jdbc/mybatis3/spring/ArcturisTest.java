package org.xyc.jdbc.mybatis3.spring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by wks on date: 2017/6/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArcturisTest {

    @Autowired
    private ArcturisService arcturisService;

    @Test
    public void testSaveArcturis() {
        int i = arcturisService.saveArcturis();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testUpdateArcturis() {
        int i = arcturisService.updateArcturis();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testDeleteArcturis() {
        int i = arcturisService.deleteArcturis();
        System.out.println("affected rows :" + i);
    }

    @Test
    public void testGetAllArcturis() {
        List<ArcturisModel> list = arcturisService.getAllArcturis();
        System.out.println(list);
    }

    @Test
    public void testGetArcturisById() {
        ArcturisModel model = arcturisService.getArcturisById();
        System.out.println(model);
    }

    @Test
    public void testInsertTwoArcturis() {
        arcturisService.insertTwoArcturis();
        System.out.println();
    }
}
