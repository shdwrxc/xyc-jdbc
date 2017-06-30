package org.xyc.jdbc.mybatis3.sample;

import java.util.List;

/**
 * created by wks on date: 2017/6/28
 */
public class TestService {

    private TestDao testDao = new TestDao();

    public int saveModel() {
        TestModel model1 = new TestModel();
        model1.setName("zhang san1");
        model1.setAge(30);
        model1.setAddress("shang hai");
        int i = testDao.saveModel(model1);
        System.out.println("affected rows :" + i);
        return i;
    }

    public int updateModel() {
        TestModel model1 = new TestModel();
        model1.setId(15);
        model1.setName("me either");
        model1.setAge(30);
        model1.setAddress("that");
        int i = testDao.updateModel(model1);
        System.out.println("affected rows :" + i);
        return i;
    }

    public int deleteModel(long id) {
        int i = testDao.deleteModel(id);
        System.out.println("affected rows :" + i);
        return i;
    }

    public List<TestModel> getAll() {
        List<TestModel> list = testDao.getAll();
        System.out.println(list);
        return list;
    }

    public TestModel getById() {
        TestModel model = testDao.getById(1);
        System.out.println(model);
        return model;
    }

    public static void main(String[] args) {
        TestService service = new TestService();
        service.saveModel();
//        service.updateModel();
//        service.deleteModel(7);
//        service.getAll();
//        service.getById();
    }
}
