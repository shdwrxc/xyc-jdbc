package org.xyc.jdbc.hibernate4.sample;

import org.springframework.stereotype.Repository;
import org.xyc.jdbc.hibernate4.GenericBaseDao;

/**
 * Created by bugu on 2016/2/20.
 */
@Repository
public class TestDaoImpl extends GenericBaseDao<TestModel> implements TestDao {

    @Override
    protected Class<TestModel> getEntityClass() {
        return TestModel.class;
    }

}
