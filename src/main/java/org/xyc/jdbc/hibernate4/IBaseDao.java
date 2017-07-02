package org.xyc.jdbc.hibernate4;

import java.io.Serializable;

/**
 * Created by ccc on 2016/2/1.
 */
public interface IBaseDao<T> {

    void save(T t);

    /**
     * @param t
     */
    T update(T t);

    /**
     * @param id
     */
    void delete(Serializable id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T find(Serializable id);
}
