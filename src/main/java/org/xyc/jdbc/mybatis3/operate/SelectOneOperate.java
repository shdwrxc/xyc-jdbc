package org.xyc.jdbc.mybatis3.operate;

/**
 * created by wks on date: 2017/6/28
 */
public interface SelectOneOperate<T, M> {

    T select(M mapper);
}
