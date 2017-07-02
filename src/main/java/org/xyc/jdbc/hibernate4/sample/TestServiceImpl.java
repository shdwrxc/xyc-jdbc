package org.xyc.jdbc.hibernate4.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bugu on 2016/2/20.
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Transactional
    public void save(TestModel model) {
        testDao.save(model);
    }

    @Transactional
    public void update(int id, String name) {
        TestModel model = testDao.find(id);
        model.setName(name);
        testDao.update(model);
    }
}
