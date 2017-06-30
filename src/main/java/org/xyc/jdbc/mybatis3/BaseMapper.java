package org.xyc.jdbc.mybatis3;

import java.util.List;

/**
 * created by wks on date: 2017/6/28
 */
public interface BaseMapper<T> {

    int insert(T t);

    int update(T t);

    int delete(long id);

    T selectOne(long id);

    List<T> selectAll();

}
