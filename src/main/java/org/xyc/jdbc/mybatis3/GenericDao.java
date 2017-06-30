package org.xyc.jdbc.mybatis3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.xyc.jdbc.mybatis3.operate.DeleteOperate;
import org.xyc.jdbc.mybatis3.operate.InsertOperate;
import org.xyc.jdbc.mybatis3.operate.SelectOneOperate;
import org.xyc.jdbc.mybatis3.operate.SelectOperate;
import org.xyc.jdbc.mybatis3.operate.UpdateOperate;

/**
 * created by wks on date: 2017/6/28
 *
 * 事务的控制，mybatis局限比较大，只能在SqlSession的范围内控制
 *
 * 推荐用spring的事务控制
 */
public class GenericDao<T, M> {

    private SqlSessionFactory sqlSessionFactory = SessionFactoryBuilder.getSqlSessionFactory();

    protected final int insert(Class<M> mapperClass, InsertOperate operate) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            M m = sqlSession.getMapper(mapperClass);
            return operate.insert(m);
        }
    }

    protected final int update(Class<M> mapperClass, UpdateOperate operate) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            M m = sqlSession.getMapper(mapperClass);
            return operate.update(m);
        }
    }

    protected final int delete(Class<M> mapperClass, DeleteOperate operate) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            M m = sqlSession.getMapper(mapperClass);
            return operate.delete(m);
        }
    }

    protected final T selectOne(Class<M> mapperClass, SelectOneOperate<T,M> operate) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            M m = sqlSession.getMapper(mapperClass);
            return operate.select(m);
        }
    }

    protected final List<T> select(Class<M> mapperClass, SelectOperate<T,M> operate) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            M m = sqlSession.getMapper(mapperClass);
            return operate.select(m);
        }
    }
}
