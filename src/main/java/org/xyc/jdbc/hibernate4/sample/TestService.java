package org.xyc.jdbc.hibernate4.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bugu on 2016/2/20.
 */
@Service("testService")
public class TestService {

    @Autowired
    private TestDao testDao;

    @Transactional
    public void save() {
        testDao.save(new TestModel("abc", 15, "hello"));
    }

    @Transactional
    public void update() {
        TestModel model = testDao.find(36);
        model.setName("afterupdate");
        testDao.update(model);
    }

    @Transactional
    public void saveTwoModels() {
        testDao.save(new TestModel("first", 15, "here"));
        int i = 10 / 0;
        testDao.save(new TestModel("second", 20, "there"));
        System.out.println("finish");
    }
}
