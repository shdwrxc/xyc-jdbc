package org.xyc.jdbc.hibernate4.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccc on 2016/2/2.
 */
public class QueryResult<T> {

    private List<T> records = new ArrayList<T>();

    private long count;

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
