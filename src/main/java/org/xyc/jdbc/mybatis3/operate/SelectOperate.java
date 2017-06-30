package org.xyc.jdbc.mybatis3.operate;

import java.util.List;

/**
 * created by wks on date: 2017/6/28
 */
public interface SelectOperate<T, M> {

    List<T> select(M mapper);
}
