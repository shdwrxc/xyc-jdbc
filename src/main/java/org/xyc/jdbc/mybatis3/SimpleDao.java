package org.xyc.jdbc.mybatis3;

import java.util.List;

import org.xyc.jdbc.mybatis3.operate.DeleteOperate;
import org.xyc.jdbc.mybatis3.operate.InsertOperate;
import org.xyc.jdbc.mybatis3.operate.SelectOneOperate;
import org.xyc.jdbc.mybatis3.operate.SelectOperate;
import org.xyc.jdbc.mybatis3.operate.UpdateOperate;

/**
 * created by wks on date: 2017/6/28
 */
public abstract class SimpleDao<T, M extends BaseMapper<T>> extends GenericDao<T, M> {

    protected final int insert(final T t) {
        return insert(getMapper(), new InsertOperate<M>() {
            @Override
            public int insert(M mapper) {
                return mapper.insert(t);
            }
        });
    }

    protected final int update(final T t) {
        return update(getMapper(), new UpdateOperate<M>() {
            @Override
            public int update(M mapper) {
                return mapper.update(t);
            }
        });
    }

    protected final int delete(final long id) {
        return delete(getMapper(), new DeleteOperate<M>() {
            @Override
            public int delete(M mapper) {
                return mapper.delete(id);
            }
        });
    }

    protected final T selectOne(final long id) {
        return selectOne(getMapper(), new SelectOneOperate<T, M>() {
            @Override
            public T select(M mapper) {
                return mapper.selectOne(id);
            }
        });
    }

    protected final List<T> selectAll() {
        return select(getMapper(), new SelectOperate<T, M>() {
            @Override
            public List<T> select(M mapper) {
                return mapper.selectAll();
            }
        });
    }

    protected abstract Class<M> getMapper();
}
