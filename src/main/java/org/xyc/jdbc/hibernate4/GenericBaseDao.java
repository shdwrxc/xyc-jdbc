package org.xyc.jdbc.hibernate4;

import org.xyc.jdbc.hibernate4.query.QueryResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ccc on 2016/2/1.
 */
public abstract class GenericBaseDao<T> {

    public static final int PAGE_MIN = 1;   //最小页数

    public static final int LIMIT_MIN = 1;  //每页最少记录数

    public static final int LIMIT_MAX = 500;    //每页最大记录数

    public static final int LIMIT_NORMAL = 20;  //正常记录数

    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    /**
     * @param t
     */
    public void save(T t) {
        entityManager.persist(t);
    }

    /**
     * @param t
     */
    public T update(T t) {
        return entityManager.merge(t);
    }

    /**
     * @param id
     */
    public void delete(Serializable id) {
        entityManager.remove(id);
    }

    /**
     *
     */
    public void flush() {
        entityManager.flush();
    }

    /**
     *
     */
    public void close() {
        entityManager.close();
    }

    /**
     * @param t
     */
    public void refresh(T t) {
        entityManager.refresh(t);
    }

    /**
     *
     */
    public void clear() {
        entityManager.clear();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public T find(Serializable id) {
        return entityManager.find(getEntityClass(), id);
    }

    /**
     * 根据本地sql查询
     *
     * @param sql
     * @param parameters
     * @return
     */
    public List<T> findByNativeSql(String sql, Object parameters) {
        return findByNativeSql(sql, parameters, PAGE_MIN, LIMIT_NORMAL);
    }

    /**
     * 根据本地sql查询
     *
     * @param sql
     * @param parameters
     * @param page
     * @param pageSize
     * @return
     */
    public List<T> findByNativeSql(String sql, Object parameters, int page, int pageSize) {
        Query query = entityManager.createNativeQuery(sql, getEntityClass());
        return createPage(createQuery(query, parameters), page, pageSize).getResultList();
    }

    /**
     * 查询总数
     *
     * @param sql
     * @param parameters
     * @return
     */
    public long findCountByNativeSql(String sql, Object parameters) {
        Query query = entityManager.createNativeQuery(sql);
        Object object = createQuery(query, parameters).getSingleResult();
        return object != null ? ((BigDecimal) object).longValue() : 0;
    }

    /**
     * 根据jpql查询
     *
     * @param jpql
     * @param parameters
     * @return
     */
    public List<T> findByJpql(String jpql, Object parameters) {
        return findByJpql(jpql, parameters, PAGE_MIN, LIMIT_NORMAL);
    }

    /**
     * 根据jpql查询
     *
     * @param jpql
     * @param parameters
     * @param page
     * @param pageSize
     * @return
     */
    public List<T> findByJpql(String jpql, Object parameters, int page, int pageSize) {
        Query query = entityManager.createQuery(jpql, getEntityClass());
        return createPage(createQuery(query, parameters), page, pageSize).getResultList();
    }

    /**
     * 查询总数
     *
     * @param jpql
     * @param parameters
     * @return
     */
    public long findCountByJpql(String jpql, Object parameters) {
        Query query = entityManager.createQuery(jpql);
        Object object = createQuery(query, parameters).getSingleResult();
        return object != null ? (Long) object : 0;
    }

    /**
     * 根据NamedQuery查询
     *
     * @param queryName
     * @param parameters
     * @return
     */
    private List<T> findByNamedQuery(String queryName, Object parameters) {
        return findByNamedQuery(queryName, parameters, PAGE_MIN, LIMIT_NORMAL);
    }

    /**
     * 根据NamedQuery查询
     *
     * @param queryName
     * @param parameters
     * @param page
     * @param pageSize
     * @return
     */
    private List<T> findByNamedQuery(String queryName, Object parameters, int page, int pageSize) {
        Query query = entityManager.createNamedQuery(queryName, getEntityClass());
        return createPage(createQuery(query, parameters), page, pageSize).getResultList();
    }

    /**
     * 设置参数
     *
     * @param query
     * @param parameters
     * @return
     */
    private Query createQuery(Query query, Object parameters) {
        if (parameters == null)
            return query;
        int index = 1;
        if (parameters instanceof ArrayList) {
            for (Object obj : (List) parameters) {
                query.setParameter(index++, obj);
            }
        } else if (parameters instanceof HashMap) {
            Map<String, Object> map = (Map) parameters;
            for (String str : map.keySet()) {
                query.setParameter(str, map.get(str));
            }
        }
        return query;
    }

    /**
     * 设置分页
     *
     * @param query
     * @param page
     * @param pageSize
     * @return
     */
    private Query createPage(Query query, int page, int pageSize) {
        if (page < PAGE_MIN)
            page = PAGE_MIN;
        if (pageSize < LIMIT_MIN)
            pageSize = LIMIT_NORMAL;
        if (pageSize > LIMIT_MAX)
            pageSize = LIMIT_MAX;
        int start = (page - 1) * pageSize;
        int offset = pageSize;
        query.setFirstResult(start);
        query.setMaxResults(offset);
        return query;
    }

    /**
     * 根据字段名查询
     *
     * @param parameters
     * @return
     */
    public QueryResult<T> findByName(Object parameters) {
        return findByName(parameters, PAGE_MIN, LIMIT_NORMAL);
    }

    /**
     * 根据字段名查询
     *
     * @param parameters 应该为map
     * @param page
     * @param pageSize
     * @return
     */
    public QueryResult<T> findByName(Object parameters, int page, int pageSize) {
        if (parameters == null)
            return new QueryResult<T>();
        if (!(parameters instanceof HashMap))
            return new QueryResult<T>();
        Map<String, Object> map = (Map<String, Object>) parameters;
        Query countQuery = createQuery(entityManager.createQuery(generateCountJpql(map), Long.class), parameters);
        Query query = createPage(createQuery(entityManager.createQuery(generateJpql(map), getEntityClass()), parameters), page, pageSize);
        return getBaseResult(countQuery, query);
    }

    /**
     * 拼接简单jpql
     *
     * @param map
     * @return
     */
    private String generateJpql(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("select o from ").append(getEntityClass().getName()).append(" o where 1=1");
        for (String str : map.keySet()) {
            sb.append(" AND o.").append(str).append(" like :").append(str);
        }
        return sb.toString();
    }

    /**
     * @param map
     * @return
     */
    private String generateCountJpql(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(o) from ").append(getEntityClass().getName()).append(" o where 1=1");
        for (String str : map.keySet()) {
            sb.append(" AND o.").append(str).append(" like :").append(str);
        }
        return sb.toString();
    }

    /**
     * @param countQuery
     * @param query
     * @return
     */
    private QueryResult<T> getBaseResult(Query countQuery, Query query) {
        Long count = (Long) countQuery.getSingleResult();
        QueryResult<T> result = new QueryResult<T>();
        result.setRecords(query.getResultList());
        result.setCount(count != null ? count.longValue() : 0);
        return result;
    }
}
