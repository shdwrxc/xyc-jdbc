package org.xyc.jdbc.mybatis3.sample;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.xyc.jdbc.mybatis3.SessionFactoryBuilder;

/**
 * created by wks on date: 2017/6/29
 */
public class TransactionSample {

    private SqlSessionFactory sqlSessionFactory = SessionFactoryBuilder.getSqlSessionFactory();

    @Test
    public void saveNotSuccess() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            sqlSession.insert("org.xyc.jdbc.mybatis3.sample.TestMapper.insert", new TestModel("me", 16, "here"));
            int i = 16 / 0;
            sqlSession.insert("org.xyc.jdbc.mybatis3.sample.TestMapper.insert", new TestModel("you", 17, "there"));
            sqlSession.commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
