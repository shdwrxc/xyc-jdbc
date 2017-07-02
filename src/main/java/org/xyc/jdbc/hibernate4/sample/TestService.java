package org.xyc.jdbc.hibernate4.sample;

/**
 * Created by bugu on 2016/2/20.
 */
public interface TestService {

    void save(TestModel model);

    void update(int id, String name);
}
