package org.xyc.jdbc.mybatis3.sample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xyc.jdbc.mybatis3.BaseMapper;

/**
 * created by wks on date: 2017/6/28
 */
public interface TestMapper extends BaseMapper<TestModel> {

    @Insert("insert into test(name, age, address) values(#{name},#{age},#{address})")
    int insert(TestModel model);

    @Update("update test set name=#{name}, age=#{age}, address=#{address} where id=#{id}")
    int update(TestModel model);

    @Delete("delete from test where id=#{id}")
    int delete(long id);

    @Select("select * from test where id=#{id}")
    TestModel selectOne(long id);

    @Select("select * from test")
    List<TestModel> selectAll();

    @Select("select * from test where age=#{age}")
    List<TestModel> selectTestsByAges(int ages);
}
