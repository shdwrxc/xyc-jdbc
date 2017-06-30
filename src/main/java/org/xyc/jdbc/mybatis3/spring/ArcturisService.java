package org.xyc.jdbc.mybatis3.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by wks on date: 2017/6/30
 */
@Service
public class ArcturisService {

    @Autowired
    private ArcturisMapper testMapper;

    public int saveArcturis() {
        ArcturisModel model1 = new ArcturisModel();
        model1.setName("friday");
        model1.setAge(33);
        model1.setAddress("guilin");
        int i = testMapper.insert(model1);
        System.out.println("affected rows :" + i);
        return i;
    }

    public int updateArcturis() {
        ArcturisModel model1 = new ArcturisModel();
        model1.setId(18);
        model1.setName("friday gone");
        model1.setAge(30);
        model1.setAddress("songjiang");
        int i = testMapper.update(model1);
        System.out.println("affected rows :" + i);
        return i;
    }

    public int deleteArcturis() {
        int i = testMapper.delete(18);
        System.out.println("affected rows :" + i);
        return i;
    }

    public List<ArcturisModel> getAllArcturis() {
        List<ArcturisModel> list = testMapper.selectAll();
        System.out.println(list);
        return list;
    }

    public ArcturisModel getArcturisById() {
        ArcturisModel arcturis = testMapper.selectOne(17);
        System.out.println(arcturis);
        return arcturis;
    }

    @Transactional
    public void insertTwoArcturis() {
        testMapper.insert(new ArcturisModel("test1", 1, "add1"));
        int i = 10 / 0;
        testMapper.insert(new ArcturisModel("test2", 2, "add2"));
        System.out.println();
    }
}
