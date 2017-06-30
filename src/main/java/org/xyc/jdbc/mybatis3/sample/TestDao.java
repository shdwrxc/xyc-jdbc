package org.xyc.jdbc.mybatis3.sample;

import java.util.List;

import org.xyc.jdbc.mybatis3.SimpleDao;

/**
 * created by wks on date: 2017/6/28
 */
public class TestDao extends SimpleDao<TestModel, TestMapper> {

    public int saveModel(TestModel model) {
        return insert(model);
    }

    public int updateModel(TestModel model) {
        return update(model);
    }

    public int deleteModel(long id) {
        return delete(id);
    }

    public List<TestModel> getAll() {
        return selectAll();
    }

    public TestModel getById(long id) {
        return selectOne(id);
    }

    @Override
    protected Class getMapper() {
        return TestMapper.class;
    }
}
