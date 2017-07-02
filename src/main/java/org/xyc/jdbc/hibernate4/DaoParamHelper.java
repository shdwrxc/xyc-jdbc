package org.xyc.jdbc.hibernate4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccc on 2016/2/1.
 */
public class DaoParamHelper {

    private Map<String, Object> map = new HashMap<String, Object>();

    public DaoParamHelper addCondition(String column, Object value) {
        map.put(column, value);
        return this;
    }

    public Map<String, Object> toParam() {
        return map;
    }
}
