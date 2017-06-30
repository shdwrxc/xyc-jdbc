package org.xyc.jdbc.mybatis3.spring;

import java.util.List;

/**
 * created by wks on date: 2017/6/28
 */
public interface ArcturisMapper {

    int insert(ArcturisModel model);

    int update(ArcturisModel model);

    int delete(long id);

    ArcturisModel selectOne(long id);

    List<ArcturisModel> selectAll();
}
